package com.deppon.dpm.login.server.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.deppon.dpm.login.server.util.FossUserContext;
import com.deppon.dpm.login.server.vo.ResourceTreeNode;
import com.deppon.dpm.tongxunlu.server.util.Constants;
import com.deppon.dpm.tongxunlu.shared.domain.UserEntity;
import com.deppon.dpm.uums.server.domain.ResourceEntity;
import com.deppon.dpm.uums.server.service.IResourceService;
import com.deppon.dpm.uums.server.service.IRoleService;
import com.deppon.foss.framework.define.FunctionType;
import com.deppon.foss.framework.exception.BusinessException;
import com.deppon.foss.framework.server.web.action.AbstractAction;
import com.deppon.foss.framework.server.web.result.json.annotation.JSON;
import com.deppon.foss.framework.shared.util.string.StringUtil;

/**
 * 功能菜单WEB接入层 ClassName: MenuAction <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * date: 2014-8-19 上午10:13:56 <br/>
 * 
 * @author 157229-zxy
 * @version
 * @since JDK 1.6
 */
public class MenuAction extends AbstractAction {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1851855354424501485L;
	/**
	 * 父功能编码
	 */
	private String node;
	/**
	 * 判断是否点击了用户常用菜单
	 */
	@SuppressWarnings("unused")
	private boolean checkUserMenu;
	/**
	 * 功能树节点集合
	 */
	@SuppressWarnings("rawtypes")
	private List<ResourceTreeNode> nodes;
	/**
	 * 用户已经设置的常用菜单ID集合
	 */
	@SuppressWarnings("unused")
	private List<String> userRes;
	/**
	 * 用于菜单树展开路径设置
	 */
	private String path = "";
	/**
	 * 菜单树展开路径集合
	 */
	private Set<String> pathList;
	/**
	 * set injection
	 */
	private IRoleService roleService;
	/**
	 * set injection
	 */
	private IResourceService resourceService;

	/**
	 * 加载菜单树 loadTree
	 * 
	 * @return
	 * @return String
	 * @since:
	 */
	@SuppressWarnings("rawtypes")
	@JSON
	public String loadTree() {
		nodes = new ArrayList<ResourceTreeNode>();
		try {
			// 得到点击的节点下的子节点菜单集合
			List<ResourceEntity> resources = findResources(node);// 跟节点=0
			for (ResourceEntity res : resources) {
				// 转换菜单对象为节点对象
				ResourceTreeNode<ResourceEntity> treeNode = changeResToTreeNode(res);
				// 判断节点是否叶子节点，如果为叶子节点，在判断节点是否有子节点，如果有子节点，那么就要把子节点加到该节点下，传到前台
				/*
				 * if (FossConstants.YES.equalsIgnoreCase(res.getLeafFlag())) {
				 * List<ResourceEntity> childResources = findResources(res
				 * .getCode()); List<ResourceTreeNode> childNodes = new
				 * ArrayList<ResourceTreeNode>(); for (ResourceEntity childRes :
				 * childResources) { ResourceTreeNode<ResourceEntity>
				 * childTreeNode = changeResToTreeNode(childRes);
				 * childNodes.add(childTreeNode); }
				 * treeNode.setChildren(childNodes); }
				 */
				nodes.add(treeNode);
			}
			return returnSuccess();
		} catch (BusinessException e) {
			return returnSuccess(e.getErrorCode());
		}
	}

	// 查询功能方法
	private List<ResourceEntity> findResources(String parentCode) {
		// 获得当前用户
		UserEntity user = FossUserContext.getCurrentUser();
		// 当前用户角色编码集合
		Set<String> resCodes = user.getOrgResCodes();
		// 当前部门未配置角色
		if (resCodes == null) {
			throw new BusinessException("foss.login.noFunction");
		}
		// 菜单对象集合
		List<ResourceEntity> resNodes = new ArrayList<ResourceEntity>();
		List<ResourceEntity> childResources = resourceService
				.getDirectChildResourceByCode(parentCode);
		for (ResourceEntity res : childResources) {
			// 判断权限是否为空
			if (res == null) {
				continue;
			}
			// 判断权限的类型是否为按钮
			if (StringUtil.equalsIgnoreCase(FunctionType.BUTTON,
					res.getResType())) {
				continue;
			}
			// 判断是否是WEB菜单
			// if (StringUtil
			// .equalsIgnoreCase(
			// DictionaryValueConstants.BSE_RESOURCE_BELONG_SYSTEM_TYPE_GUI,
			// res.getBelongSystemType())) {
			// continue;
			// }
			// 判断权限为非检查的权限时，直接增加到权限列表中
			if (StringUtil.equalsIgnoreCase(Constants.ACTIVE_NO,
					res.getChecked())) {
				resNodes.add(res);
				continue;
			}
			if (resCodes.contains(res.getCode())) {
				resNodes.add(res);
			}
		}
		return resNodes;
	}

	// 转换菜单对象为树节点对象
	private ResourceTreeNode<ResourceEntity> changeResToTreeNode(
			ResourceEntity res) {
		ResourceTreeNode<ResourceEntity> treeNode = new ResourceTreeNode<ResourceEntity>();
		treeNode.setId(res.getFunctionCode());
		treeNode.setText(res.getName());
		treeNode.setExpandable(!Constants.ACTIVE_YES.equalsIgnoreCase(res.getLeafFlag()));
		treeNode.setCls(res.getCls());
		treeNode.setIconCls(res.getIconCls());
		treeNode.setDisplayOrder(res.getDisplayOrder());
		if (res.getResType().equalsIgnoreCase(FunctionType.MENU)) {
			treeNode.setUri(res.getUri());
			treeNode.setLeaf(true);
		} else {
			treeNode.setLeaf(false);
		}
		if (res.getParentRes() != null) {
			treeNode.setParentId(res.getParentRes().getCode());
		} else {
			treeNode.setParentId(null);
		}
		// treeNode.setEntity(res);
		return treeNode;
	}

	/**
	 * set
	 * 
	 * @param node
	 */
	public void setNode(String node) {
		this.node = node;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List<ResourceTreeNode> getNodes() {
		return nodes;
	}

	/**
	 * set
	 * 
	 * @param userRes
	 */
	public void setUserRes(List<String> userRes) {
		this.userRes = userRes;
	}

	/**
	 * set
	 * 
	 * @param checkUserMenu
	 */
	public void setCheckUserMenu(boolean checkUserMenu) {
		this.checkUserMenu = checkUserMenu;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getPath() {
		return path;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public Set<String> getPathList() {
		return pathList;
	}

	/**
	 * set
	 * 
	 * @param roleService
	 */
	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public IResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * set
	 * 
	 * @param resourceService
	 */
	public void setResourceService(IResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public IRoleService getRoleService() {
		return roleService;
	}
}
