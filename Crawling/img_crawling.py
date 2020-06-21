import requests

from bs4 import BeautifulSoup
from urllib.request import urlopen
from pandas import DataFrame as df

response = urlopen('http://cu.bgfretail.com/product/productAjax.do?pageIndex=1&searchMainCategory=10&searchSubCategory=&listType=0&searchCondition=setA&searchUseYn=N&gdIdx=0&codeParent=10&user_id=&search2=&searchKeyword=')

soup = BeautifulSoup(response, 'html.parser')
i = 1
for img_url in soup.select('img[src*=".jpg"]'): 
    url = img_url.get('src', '/')
    r = requests.get(url)
    file = open("/workspace/crawling/CU_img_all/" + str(i) + ".jpg","wb")
    i += 1
    file.write(r.content)
    file.close()



