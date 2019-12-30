package com.grizzly.service;

import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;

import com.grizzly.model.AppCategory;
import com.grizzly.model.AppInfo;
import com.grizzly.model.AppVersion;
import com.grizzly.model.DataDictionary;
import com.grizzly.model.DevUser;
import com.grizzly.utils.PageInfo;


public interface DeveloperService {
    public String getAppInforms(Model model);

    PageInfo<AppInfo> allAppInformByPage(Map<String, Object> params);
    /**
	 * 根据父节点parentId获取相应的分类列表
	 * @param parentId
	 * @return
	 * @throws Exception
	 */
	public List<AppCategory> getAppCategoryListByParentId(Integer parentId)throws Exception;
	
	/**
	 * 新增app
	 * @param appInfo
	 * @return
	 * @throws Exception
	 */
	public boolean add(AppInfo appInfo) throws Exception;
	/**
	 * 修改app信息
	 * @param appInfo
	 * @return
	 * @throws Exception
	 */
	public boolean modify(AppInfo appInfo)throws Exception;
	
	/**
	 * 根据appId删除app应用
	 * @param delId
	 * @return
	 * @throws Exception
	 */
	public boolean deleteAppInfoById(Integer delId)throws Exception;
	
	/**
	 * 根据条件查询出app列表
	 * @param querySoftwareName
	 * @param queryStatus
	 * @param queryCategoryLevel1
	 * @param queryCategoryLevel2
	 * @param queryCategoryLevel3
	 * @param queryFlatformId
	 * @param devId
	 * @param currentPageNo
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public List<AppInfo> getAppInfoList(String querySoftwareName,Integer queryStatus,
								Integer queryCategoryLevel1,Integer queryCategoryLevel2,
								Integer queryCategoryLevel3,Integer queryFlatformId,
								Integer devId,Integer currentPageNo,Integer pageSize)throws Exception;
	
	/**
	 * 根据条件查询appInfo表记录数
	 * @param querySoftwareName
	 * @param queryStatus
	 * @param queryCategoryLevel1
	 * @param queryCategoryLevel2
	 * @param queryCategoryLevel3
	 * @param queryFlatformId
	 * @param devId
	 * @return
	 * @throws Exception
	 */
	public int getAppInfoCount(String querySoftwareName,Integer queryStatus,
							Integer queryCategoryLevel1,Integer queryCategoryLevel2,
							Integer queryCategoryLevel3,Integer queryFlatformId,Integer devId)throws Exception;
	/**
	 * 根据id、apkName查找appInfo
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public AppInfo getAppInfo(Integer id,String APKName)throws Exception;
	
	/**
	 * 删除logo图片
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean deleteAppLogo(Integer id)throws Exception;
	
	/**
	 * 通过appId删除app应用(app_info、app_version)
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean appsysdeleteAppById(Integer id)throws Exception;
	
	
	/**
	 * update Sale Status By AppId and Operator
	 * @param appId
	 * @return
	 * @throws Exception
	 */
	public boolean appsysUpdateSaleStatusByAppId(AppInfo appInfo) throws Exception;
	
	/**
	 * 根据appId查询相应的app版本列表
	 * @param appId
	 * @return
	 * @throws Exception
	 */
	public List<AppVersion> getAppVersionList(Integer appId)throws Exception;
	/**
	 * 新增app版本信息，并更新app_info表的versionId字段
	 * @param appVersion
	 * @return
	 * @throws Exception
	 */
	public boolean appsysadd(AppVersion appVersion)throws Exception;
	/**
	 * 根据id获取AppVersion
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public AppVersion getAppVersionById(Integer id)throws Exception;
	
	/**
	 * 修改app版本信息
	 * @param appVersion
	 * @return
	 * @throws Exception
	 */
	public boolean modify(AppVersion appVersion)throws Exception;
	
	/**
	 * 删除apk文件
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean deleteApkFile(Integer id)throws Exception;
	
	/**
	 * 根据typeCode查询相应的数据字典列表
	 * @param typeCode
	 * @return
	 * @throws Exception
	 */
	public List<DataDictionary> getDataDictionaryList(String typeCode)throws Exception;
	
	/**
	 * 用户登录
	 * @param devCode
	 * @param devPassword
	 * @return
	 */
	public DevUser login(String devCode,String devPassword) throws Exception;
}