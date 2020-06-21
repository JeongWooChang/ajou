from bs4 import BeautifulSoup
from urllib.request import urlopen
from pandas import DataFrame as df
import requests
import json
import re
from pandas import DataFrame as df
import urllib.request
 

response = urlopen('https://www.ministop.co.kr/MiniStopHomePage/page/guide/list_4.do')   ## list_숫자.do
soup = BeautifulSoup(response, 'html.parser')

i = 0 
a=[]
b=[]
c=[]

for name in soup.select('div ul li a img'):
    a.append(name.get('alt'))
    #print(name.get('alt'))
for price in soup.select('div ul li a p strong'): 
    b.append(price.get_text())
    #print(price.get_text())
for img_url in soup.select('img[src*=".jpg"]'): 
    imgurl = "https://www.ministop.co.kr/MiniStopHomePage/page"+img_url.get('src', '/')
    c.append(imgurl.replace("..",""))
    print(imgurl.replace("..",""))
    urllib.request.urlretrieve(imgurl.replace("..",""), "/workspace/crawling/Mini/Mini_img_Sandwich/" + str(a[i]) + ".jpg")
    i += 1

    
########## 더보기 페이지 추가 추출


custom_header = {
    ## list_숫자.do
    'refer' : "https://www.ministop.co.kr/MiniStopHomePage/page/guide/list_4.do", 
    #고정
    'user-agent' : "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.132 Safari/537.36",  }

#do?뒤의 쿼리문만 변경
url = "https://www.ministop.co.kr/MiniStopHomePage/page/querySimple.do?pageId=guide/list_4&sqlnum=1&paramInfo=3%3A31%3A313%3A0%3A99999999%3A%3A&pageNum=2&sortGu=byRegDate&tm=1584613602200"
#이미지 주소 https://www.ministop.co.kr/MiniStopHomePage/page/pic.do?n=goods. + "~"

req = requests.get(url, headers = custom_header)
if req.status_code == requests.codes.ok:
    print("접속 성공")
    stock_data = json.loads(req.text)
    for field in  stock_data["recordList"]:
        field2 = re.sub('[-=+,#/\?:^$@*\"※~&%ㆍ!』\\‘|\(\)\<\>\{\}`\'…》]', '', str(field)) 
        field2 = re.sub('rowNum', '', field2)
        field2 = re.sub('fields', '', field2)
        field2 = field2.split()
        a.append(re.sub('\[', '', field2[1]))
        #print(re.sub('\[', '', field2[1]))
        b.append(field2[2])
        field2[6] = field2[6][:-1]
        
        #햄버거(pic.do?n=softhamburger.)제외 나머지 이미지 주소는 goods
        field2[6] = "https://www.ministop.co.kr/MiniStopHomePage/page/pic.do?n=goods." + field2[6]
        c.append(field2[6])  
        print(field2[6])
        #이미지 저장 구문
        urllib.request.urlretrieve(field2[6], "/workspace/crawling/Mini/Mini_img_Sandwich/" + str(re.sub('\[', '', field2[1])) + ".jpg")
        #i += 1

#csv 파일 생성
df1 = df({"prodName" : list(a), "prodPirce" : list(b), "img_url" : list(c)})

df1.to_csv('Mini_.csv', index=False)

