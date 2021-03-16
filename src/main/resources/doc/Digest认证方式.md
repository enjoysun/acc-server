#### Digest的Authorization组成  

Authorization: 
Digest 
username="系统用户名(一般为客户端填充)" 
realm="领域，一般由服务端来定制" 
nonce="服务端返回的随机数种子"
method="请求的方法" 
uri="请求接口或资源地址(只是ｐａｔｈ)" 
algorithm="指定response计算算法"
cnonce="客户端指定的随机数种子"
nc="请求次数"
qop="进一步确定response的算法"
response="认证的主要值，除了 algorithm其余皆要参与运算得出response"  

#### Digest认证计算方法  

##### RFC 2069 简易计算方法  

HA1=MD5(username:realm:password)
HA2=MD5(method:uri)
response=MD5(HA1:nonce:HA2)  

##### RFC 2617 增强计算方法  

######HA1部分
当algorithm值为"MD5"或未指定时，HA1计算方法如下
HA1 = MD5(username:realm:password)
当algorithm值为"MD5-sess"时，HA1计算方法如下
HA1 = MD5(MD5(username:realm:password):nonce:cnonce)

######HA2部分
当qop值为"auth"或未指定时，HA2计算方法如下
HA2 = MD5(method:uri)
当qop值为"auth-int"时，HA2计算方法如下；entityBody是指整个body（？）
HA2 = MD5(method:uri:MD5(entityBody))

#######response部分
当qop值为"auth"或"auth-int"时，response计算方法如下
response = MD5(HA1:nonce:nonceCount:cnonce:qop:HA2)
当qop未指定时，response计算方法如下
response = MD5(HA1:nonce:HA2)