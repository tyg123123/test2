<html>
<body>
<h2>Hello World!</h2>

<table id="tt">
      $('#tt').datagrid({
      url:'datagrid_data.json',
      columns:[[
      {field:'code',title:'Code',width:100},
     {field:'name',title:'Name',width:100},
      {field:'price',title:'Price',width:100,align:'right'}
     ]]
    });
</table>
</body>
</html>
