<?php


  		 function testdml(){
			require_once 'sqlTool.php';
			$sqltool = new SqlTool();
			
			$sql="insert into user1 (name,password,email,age) values ('zhang',md5('123456'),'zs@sohu.com',30);";
			
			$res = $sqltool->execute_dml($sql);
			 
			if($res==0){
				
				echo "ʧ��";
				
			}else if ($res==1){
				
				echo "�ɹ�";
			}else {
				echo "û�иı�";
			}
	  	 }
	  	 
	  	 function testdql(){
	  	 	require_once 'sqlTool.php';
	  	 	
	  	 	$sqltool = new SqlTool();
	  	 		
	  	 	$sql="select * from user1";
	  	 		
	  	 	$res = $sqltool->execute_dql($sql);
	  	 while($row=mysql_fetch_row($res)){
	  	 	
	  	 	
	  	 		foreach($row as  $var){
	  	 			
	  	 			echo "***   ".$var;
	  	 		}
	  	 		echo "<br/>";
	  	 	}
	  	 	mysql_free_result($res);
	  	 }
	  	  
	  	 
	  	 testdql();
	  	// testdml()
?>