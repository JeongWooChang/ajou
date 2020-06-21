from bs4 import BeautifulSoup
from urllib.request import urlopen
from pandas import DataFrame as df

response = urlopen('http://cu.bgfretail.com/product/productAjax.do?pageIndex=1&searchMainCategory=10&searchSubCategory=3&listType=0&searchCondition=setA&searchUseYn=N&gdIdx=0&codeParent=10&user_id=&search2=&searchKeyword=')
soup = BeautifulSoup(response, 'html.parser')

a=[]
b=[]
c=[]
for price in soup.select('p.prodPrice'):
    a.append(price.get_text())
    #print(price.get_text())
for name in soup.select('p.prodName'): 
    b.append(name.get_text())
    #print(name.get_text())
for img_url in soup.select('img[src*=".jpg"]'): 
    c.append(img_url.get('src', '/'))
    #print(img_url.get('src', '/'))

df1 = df({"prodName" : list(b), "prodPirce" : list(a), "img_url" : list(c)})

df1.to_csv('CU_ham.csv', index=False)

