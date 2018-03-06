#使用说明

###1、使用之前，你需知道：

      * 本项目不支持多表操作以及数据库事务。多表操作需要自己写代码，可以提供有关接口。
      * 本项目是在jdk1.8上完成，所以最好你安装的Java版本是1.8，如果你不想更换版本，请在eclipse->proference->compile 中更换	Java编译版本。
      * 你需要安装MySQL数据库。
      * 你有tomcat服务器。
      
###2、使用前的准备

	  * 打开你的sqlyog链接数据库，并且新建一个数据库，例如起名myproject，记住这个，后面会用到。
	  * 解压压缩包会用两个工程，GenericCode是创建数据库表、生成代码以及jsp的工程。MyProject是在CodeGeneric生成代码之后将有关的	生成的东西复制到该工程。
	  
###3、简介：
	  * 可以快速生成一张表的增删改查以及jsp界面，并且可以再tomcat服务器上运行。
	  * 本项目可以生成Java代码（不用自己写pojo dao）,创建表（你不需要去数据库中自己创建），创建jsp(生成具有简单的增删改查的jsp界面)
	  
###4、开始吧！

	  # 1、解压zip包，得到两个工程，都分别导入eclipse。
	  # 2、运行GenericCode，右键->run on server。
	  # 3、在浏览器输入http://localhost:8080/GenericCode/或者http://localhost:8080/GenericCode/index.jsp
	  # 4、你会看到一个界面，填写上面要求的。那上面属性有很多行，你只需要填写你需要的，其他的可以空着不用管。必填项必须填。除此之外你必须保证数据库用户名、密码、你新建的数据库都正确（这个就是你上面建的myproject数据库）。然后在创建你的表，例如你命名student，一次只能创建一张表。写你的属性例如学生姓名、性别等，然后提交。
	  # 5、以上完成之后，你会在你的d盘下有一个myproject下面会有com和view目录。view目录下会有Student目录（根据你的表名生成的）。
	  # 6、把com目录整个复制，粘贴到MyProject工程src目录下，再把view目录下你生成的Student目录，粘贴到MyProject的WebContent下。
	  # 7、你现在可以运行MyProject右键->run on server。然后在浏览器中输入http://localhost:8080/MyProject/Student/list.jsp(注意：这里面的Student就是你的Student目录，粘贴到WebContent下要想访问Student目录下的jsp必须写全路径)
	  # 8、完结。

### 5、注意事项

	  # 1.当你创建第二张表时，这时候到com目录下一层一层找有个dao文件夹以及一个pojo文件夹把这两个文件上新的Java对象分别放入MyProject的com.project.dao以及com.project.pojo中。
	  # 2.如果你的主键名称是自己写的，那么请在update.jsp中第23行 ->TestDao.update(p,"id");把id换为你自己写的。
	  # 3.若果你其他步骤都对只是最后复制jsp发现jsp中有错而且是导包错误，那么这是缓存的缘故，重新clean项目或者把包重新导一次。
	  # 4.MyProject不是必须的，你也可以自己生成一个web工程，只是要导入BeanUtils.jar、commonlog.jar以及mysql-connection.jar 这三个jar包。
##### Author_By@ly