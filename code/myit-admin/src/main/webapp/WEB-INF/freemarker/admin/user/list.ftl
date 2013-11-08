  <tbody>
    <tr>
      <td>1</td>
      <td>Mark</td>
      <td>Tompson</td>
      <td>the_mark7</td>
      <td>cab79</td>
      <td>cab79</td>
      <td>cab79</td>
      <td>
          <a href="user.html"><i class="icon-pencil"></i></a>
          <a data-toggle="modal" role="button" href="#myModal"><i class="icon-remove"></i></a>
      </td>
    </tr>
    <tr>
      <td>2</td>
      <td>Ashley</td>
      <td>Jacobs</td>
      <td>ash11927</td>
      <td>cab79</td>
      <td>cab79</td>
      <td>cab79</td>
      <td>
          <a href="user.html"><i class="icon-pencil"></i></a>
          <a data-toggle="modal" role="button" href="#myModal"><i class="icon-remove"></i></a>
      </td>
    </tr>
    <tr>
      <td>3</td>
      <td>Audrey</td>
      <td>Ann</td>
      <td>audann84</td>
      <td>cab79</td>
      <td>cab79</td>
      <td>cab79</td>
      <td>
          <a href="user.html"><i class="icon-pencil"></i></a>
          <a data-toggle="modal" role="button" href="#myModal"><i class="icon-remove"></i></a>
      </td>
    </tr>
    <tr>
      <td>4</td>
      <td>John</td>
      <td>Robinson</td>
      <td>jr5527</td>
      <td>cab79</td>
      <td>cab79</td>
      <td>cab79</td>
      <td>
          <a href="user.html"><i class="icon-pencil"></i></a>
          <a data-toggle="modal" role="button" href="#myModal"><i class="icon-remove"></i></a>
      </td>
    </tr>
    <tr>
      <td>5</td>
      <td>Aaron</td>
      <td>Butler</td>
      <td>aaron_butler</td>
      <td>cab79</td>
      <td>cab79</td>
      <td>cab79</td>
      <td>
          <a href="user.html"><i class="icon-pencil"></i></a>
          <a data-toggle="modal" role="button" href="#myModal"><i class="icon-remove"></i></a>
      </td>
    </tr>
    <tr>
      <td>6</td>
      <td>Chris</td>
      <td>Albert</td>
      <td>cab79</td>
      <td>cab79</td>
      <td>cab79</td>
      <td>cab79</td>
      <td>
          <a href="user.html"><i class="icon-pencil"></i></a>
          <a data-toggle="modal" role="button" href="#myModal"><i class="icon-remove"></i></a>
      </td>
    </tr>
  </tbody>
<#-- 引用资源宏文件 -->
<#import "/common/res.ftl" as res>
<#assign js = ["js/pagnation"
] >
<@res.js url = js />
<script>
	$(function(){
		//分页
		showPagenation(3,120, $("#toolbarCon"));
	
	});
</script>