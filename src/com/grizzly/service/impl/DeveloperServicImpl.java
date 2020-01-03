package com.grizzly.service.impl;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.grizzly.dao.AppCategoryMapper;
import com.grizzly.dao.AppInfoMapper;
import com.grizzly.dao.AppVersionMapper;
import com.grizzly.dao.DataDictionaryMapper;
import com.grizzly.dao.DevUserMapper;
import com.grizzly.dao.DeveloperMapper;
import com.grizzly.model.AppCategory;
import com.grizzly.model.AppInfo;
import com.grizzly.model.AppVersion;
import com.grizzly.model.DataDictionary;
import com.grizzly.model.DevUser;
import com.grizzly.service.DeveloperService;
import com.grizzly.utils.PageInfo;




@Service("Developer")
@Transactional
public class DeveloperServicImpl implements DeveloperService {
    @Resource
    public DeveloperMapper developerMapper;
    @Resource
	private AppCategoryMapper appCategoryMapper;
	@Resource
	private AppInfoMapper appInfoMapper;
	@Resource
	private AppVersionMapper appVersionMapper;
	@Resource
	private DataDictionaryMapper dataDictionaryMapper;
	@Resource
	private DevUserMapper devUserMapper;


    @Override
    public String getAppInforms(Model model) {
        // TODO Auto-generated method stub
        List<AppInfo> appinforms = developerMapper.allAppInform();
        System.out.println("共有" + appinforms.size() + "条产品信息");
        model.addAttribute("appinforms", appinforms);
        return "main";
    }

    @Override
    public PageInfo<AppInfo> allAppInformByPage(Map<String, Object> params) {
        PageInfo<AppInfo> pageInfo = new PageInfo<AppInfo>();
        if (params.containsKey("pageNow")) {
            Integer pageNow = (Integer) params.get("pageNow");
            pageInfo.setPageNow(pageNow);
        }
        pageInfo.setCount(developerMapper.countAppInforms(params));

        params.put("start", (pageInfo.getPageNow() - 1) * pageInfo.getPageSize());
        params.put("size", pageInfo.getPageSize());

        System.out.println(params.toString());

        pageInfo.setList(developerMapper.selectByPage(params));
        return pageInfo;
    }
    

	
	@Override
	public List<AppCategory> getAppCategoryListByParentId(Integer parentId)
			throws Exception {
		// TODO Auto-generated method stub
		return appCategoryMapper.getAppCategoryListByParentId(parentId);
	}
	
	@Override
	public boolean add(AppInfo appInfo) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		if(appInfoMapper.add(appInfo) > 0){
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean modify(AppInfo appInfo) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		if(appInfoMapper.modify(appInfo) > 0){
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean deleteAppInfoById(Integer delId) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		if(appInfoMapper.deleteAppInfoById(delId) > 0){
			flag = true;
		}
		return flag;
	}

	@Override
	public AppInfo getAppInfo(Integer id,String APKName) throws Exception {
		// TODO Auto-generated method stub
		return appInfoMapper.getAppInfo(id,APKName);
	}

	@Override
	public List<AppInfo> getAppInfoList(String querySoftwareName,
									Integer queryStatus, Integer queryCategoryLevel1,
									Integer queryCategoryLevel2, Integer queryCategoryLevel3,
									Integer queryFlatformId, Integer devId, Integer currentPageNo,
									Integer pageSize) throws Exception {
		// TODO Auto-generated method stub
		return appInfoMapper.getAppInfoList(querySoftwareName, queryStatus, queryCategoryLevel1, queryCategoryLevel2, queryCategoryLevel3, queryFlatformId, devId, (currentPageNo-1)*pageSize, pageSize);
	}

	@Override
	public int getAppInfoCount(String querySoftwareName, Integer queryStatus,
			Integer queryCategoryLevel1, Integer queryCategoryLevel2,
			Integer queryCategoryLevel3, Integer queryFlatformId, Integer devId)
			throws Exception {
		// TODO Auto-generated method stub
		return appInfoMapper.getAppInfoCount(querySoftwareName, queryStatus, queryCategoryLevel1, queryCategoryLevel2, queryCategoryLevel3, queryFlatformId,devId);
	}

	@Override
	public boolean deleteAppLogo(Integer id) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		if(appInfoMapper.deleteAppLogo(id) > 0){
			flag = true;
		}
		return flag;
	}
	
	/**
	 * 业务：根据appId删除APP信息
	 * 1、通过appId，查询app_verion表中是否有数据
	 * 2、若版本表中有该app应用对应的版本信息，则进行级联删除，先删版本信息（app_version），后删app基本信息（app_info）
	 * 3、若版本表中无该app应用对应的版本信息，则直接删除app基本信息（app_info）。
	 * 注意：事务控制，上传文件的删除
	 */
	@Override
	public boolean appsysdeleteAppById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		int versionCount = appVersionMapper.getVersionCountByAppId(id);
		List<AppVersion> appVersionList = null;
		if(versionCount > 0){//1 先删版本信息
			//<1> 删除上传的apk文件
			appVersionList = appVersionMapper.getAppVersionList(id);
			for(AppVersion appVersion:appVersionList){
				if(appVersion.getApkLocPath() != null && !appVersion.getApkLocPath().equals("")){
					File file = new File(appVersion.getApkLocPath());
					if(file.exists()){
						if(!file.delete())
							throw new Exception();
					}
				}
			}			
			//<2> 删除app_version表数据
			appVersionMapper.deleteVersionByAppId(id);
		}
		//2 再删app基础信息
		//<1> 删除上传的logo图片
		AppInfo appInfo = appInfoMapper.getAppInfo(id, null);
		if(appInfo.getLogoLocPath() != null && !appInfo.getLogoLocPath().equals("")){
			File file = new File(appInfo.getLogoLocPath());
			if(file.exists()){
				if(!file.delete())
					throw new Exception();
			}
		}
		//<2> 删除app_info表数据
		if(appInfoMapper.deleteAppInfoById(id) > 0){
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean appsysUpdateSaleStatusByAppId(AppInfo appInfoObj) throws Exception {
		/*
		 * 上架： 
			1 更改status由【2 or 5】 to 4 ， 上架时间
			2 根据versionid 更新 publishStauts 为 2 
			
			下架：
			更改status 由4给为5
		 */
		
		Integer operator = appInfoObj.getModifyBy();
		if(operator < 0 || appInfoObj.getId() < 0 ){
			throw new Exception();
		}
		
		//get appinfo by appid
		AppInfo appInfo = appInfoMapper.getAppInfo(appInfoObj.getId(), null);
		if(null == appInfo){
			return false;
		}else{
			switch (appInfo.getStatus()) {
				case 2: //当状态为审核通过时，可以进行上架操作
					onSale(appInfo,operator,4,2);
					break;
				case 5://当状态为下架时，可以进行上架操作
					onSale(appInfo,operator,4,2);
					break;
				case 4://当状态为上架时，可以进行下架操作
					offSale(appInfo,operator,5);
					break;

			default:
				return false;
			}
		}
		return true;
	}
	
	
	/**
	 * on Sale
	 * @param appInfo
	 * @param operator
	 * @param appInfStatus
	 * @param versionStatus
	 * @throws Exception
	 */
	private void onSale(AppInfo appInfo,Integer operator,Integer appInfStatus,Integer versionStatus) throws Exception{
		offSale(appInfo,operator,appInfStatus);
		setSaleSwitchToAppVersion(appInfo,operator,versionStatus);
	}
	
	
	/**
	 * offSale
	 * @param appInfo
	 * @param operator
	 * @param appInfStatus
	 * @return
	 * @throws Exception
	 */
	private boolean offSale(AppInfo appInfo,Integer operator,Integer appInfStatus) throws Exception{
		AppInfo _appInfo = new AppInfo();
		_appInfo.setId(appInfo.getId());
		_appInfo.setStatus(appInfStatus);
		_appInfo.setModifyBy(operator);
		_appInfo.setOffSaleDate(new Date(System.currentTimeMillis()));
		appInfoMapper.modify(_appInfo);
		return true;
	}
	
	/**
	 * set sale method to on or off
	 * @param appInfo
	 * @param operator
	 * @return
	 * @throws Exception
	 */
	private boolean setSaleSwitchToAppVersion(AppInfo appInfo,Integer operator,Integer saleStatus) throws Exception{
		AppVersion appVersion = new AppVersion();
		appVersion.setId(appInfo.getVersionId());
		appVersion.setPublishStatus(saleStatus);
		appVersion.setModifyBy(operator);
		appVersion.setModifyDate(new Date(System.currentTimeMillis()));
		appVersionMapper.modify(appVersion);
		return false;
	}
	
	@Override
	public List<AppVersion> getAppVersionList(Integer appId) throws Exception {
		// TODO Auto-generated method stub
		return appVersionMapper.getAppVersionList(appId);
	}
	/**
	 * 业务：新增app的版本信息
	 * 1、app_verion表插入数据
	 * 2、更新app_info表对应app的versionId字段（记录最新版本id）
	 * 注意：事务控制
	 */
	@Override
	public boolean appsysadd(AppVersion appVersion) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		Integer versionId = null;
		if(appVersionMapper.add(appVersion) > 0){
			versionId = appVersion.getId();
			flag = true;
		}
		if(appInfoMapper.updateVersionId(versionId, appVersion.getAppId()) > 0 && flag){
			flag = true;
		}
		return flag;
	}
	@Override
	public AppVersion getAppVersionById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return appVersionMapper.getAppVersionById(id);
	}
	@Override
	public boolean modify(AppVersion appVersion) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		if(appVersionMapper.modify(appVersion) > 0){
			flag = true;
		}
		return flag;
	}
	@Override
	public boolean deleteApkFile(Integer id) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		if(appVersionMapper.deleteApkFile(id) > 0){
			flag = true;
		}
		return flag;
	}
	
	@Override
	public List<DataDictionary> getDataDictionaryList(String typeCode)
			throws Exception {
		// TODO Auto-generated method stub
		return dataDictionaryMapper.getDataDictionaryList(typeCode);
	}
	
	@Override
	public DevUser login(String devCode, String devPassword) throws Exception {
		// TODO Auto-generated method stub
		DevUser user = null;
		user = devUserMapper.getLoginUser(devCode);
		//匹配密码
		if(null != user){
			if(!user.getDevPassword().equals(devPassword))
				user = null;
		}
		return user;
	}

	@Override
	public Boolean addDevInfo(DevUser devUser) {
		Boolean flag = false;
		if(devUserMapper.addDevInfo(devUser)>0)
			flag=true;
		return flag;
	}

	@Override
	public Boolean findDevByCode(String devCode) {
		Boolean flag = false;
		if(devUserMapper.findDevByCode(devCode)>0)
			flag=true;
		return flag;
	}

	@Override
	public DevUser getDevById(int devId) {
		
		return devUserMapper.getDevById(devId);
	}

	@Override
	public Boolean updateDevInfo(DevUser devUser) {
		Boolean flag = false;
		if(devUserMapper.updateDevInfo(devUser)>0)
			flag=true;
		return flag;
	}
}
