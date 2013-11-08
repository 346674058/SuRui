<#-- 查询字段 -->
<div class="panel">
<form>
	<label>用户名</lable><input id="userName" name="userName" type="text" value="">
	<label>状态</lable><select id="status" name="status" >
		<option value="">全部</option>
		<option value="0">启用</option>
		<option value="-1">禁用</option>
	</select>
	
	<span type="button" id="query-btn" class="btn btn-primary"><i class="icon-search"></i>查询</span>
</form>
</div>

<#-- 工具栏 -->
<div class="btn-toolbar">
    <button class="btn btn-primary"><i class="icon-plus"></i>新增</button>
    <button class="btn">导入</button>
    <button class="btn">导出</button>
  <div class="btn-group">
  </div>
</div>

<#-- 结果列表 -->
<div class="well">
    <table id="user-list" class="table">
      <thead>
        <tr>
          <th>#</th>
          <th>用户名</th>
          <th>姓名</th>
          <th>手机/联系电话</th>
          <th>地址</th>
          <th>最后登录时间</th>
          <th>状态</th>
          <th style="width: 26px;"></th>
        </tr>
      </thead>
      <tbody>
      </tbody>
    </table>
</div>

<#-- 分页 -->
<div id="pagnationCon">
</div>

<#-- 对话框 -->
<div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal small hide fade">
    <div class="modal-header">
        <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
        <h3 id="myModalLabel">Delete Confirmation</h3>
    </div>
    <div class="modal-body">
        <p class="error-text"><i class="icon-warning-sign modal-icon"></i>Are you sure you want to delete the user?</p>
    </div>
    <div class="modal-footer">
        <button aria-hidden="true" data-dismiss="modal" class="btn">Cancel</button>
        <button data-dismiss="modal" class="btn btn-danger">Delete</button>
    </div>
</div>

<table id="user-item" style="display:none;">
	<tr>
      <td></td>
      <td>{userName}</td>
      <td>{realName}</td>
      <td>{mobile}</td>
      <td>{telephone}</td>
      <td>{address}</td>
      <td>{status}</td>
      <td>
          <a href="user.html"><i class="icon-pencil"></i></a>
          <a data-toggle="modal" role="button" href="#myModal"><i class="icon-remove"></i></a>
      </td>
    </tr>
</table>


<#-- 引用资源宏文件 -->
<#import "/common/res.ftl" as res>
<#assign js = ["js/pagnation",
	"js/custom/users"
] >
<@res.js url = js />
