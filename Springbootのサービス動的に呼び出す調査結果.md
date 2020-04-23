# 

- 動的に呼び出すサービスは同じinterfaceをimplementしたほうが良い。  
  同じinterfaceを利用しないと、`Map<String,Object> map`でもAutowriedできるが、利用はやりづらい。  
- MapまたListどちらでも使える。Mapのほうが良い、Key(`server名`)があるから、必要なServiceはmap.get(`server名`)で取れる。

    - サービス1の抜粋  
    >
    > ``` java
    > @Service(value="サービス1")
    > //@Service("サービス1")  //この書き方もよい
    > public class UserServiceImpl2 implements MyService {
    > ...
    > }
    > ```



    - サービス2の抜粋  
    >
    > ``` java
    > @Service(value="サービス2")
    > //@Service("サービス2")  //この書き方もよい
    > public class UserServiceImpl2 implements MyService {
    > ...
    > }
    > ```

   - コントローラの抜粋  
    >  
    > ``` java
    > @RestController
    > public class HelloWorldController {
	> private static Logger LOG=LoggerFactory.getLogger(HelloWorldController.class);
	>
	> @Autowired
    > //private List<MyService> services;
	> private Map<String,MyService> services;
	>
    > @RequestMapping("/hello")
    > public String index() {
    > 	String returnstr="";
    > 	LOG.info("---------开始----------");
    > //     	for(MyService s:services) {
    > //    		s.addUser();
    > //    	}
    >     	services.get("サービス1").addUser();
    >     	services.get("サービス2").addUser();
    >         return returnstr;
    >     }
    > }
    > ```