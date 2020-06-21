from selenium import webdriver
from bs4 import BeautifulSoup
import pandas as pd
import time
import re
import csv
from selenium import webdriver
from pandas import DataFrame as df
import requests



driver = webdriver.Chrome('/Users/amugae/Downloads/chromedriver')

base_url = 'http://gs25.gsretail.com/gscvs/ko/products/youus-freshfood'
i = 0
a = []
b = []
c = []
driver.get(base_url)
driver.find_element_by_xpath('//*[@id="productSnack"]').click()
time.sleep(1)

html = driver.page_source
soup = BeautifulSoup(html, 'html.parser')


for price in soup.select('ul li div p span.cost'):
    a.append(price.get_text().encode('utf8'))
    print(price.get_text().encode('utf8'))
for name in soup.select('ul li div p.tit'):
    b.append(name.get_text().encode('utf8'))
    print(name.get_text().encode('utf8'))
for img_url in soup.select('ul li div.prod_box p.img img[src*=".jpg"]'):
    c.append(str(img_url.get('src', '/')))
    print(img_url.get('src', '/'))
    r = requests.get(img_url.get('src', '/'))
    file = open("/Users/amugae/Downloads/GS25/img_Simple/" + str(b[i]) + ".jpg", "wb")
    i += 1
    file.write(r.content)
    file.close()


df1 = df({"prodName" : list(b), "prodPirce" : list(a), "img_url" : list(c)})

df1.to_csv('/Users/amugae/Downloads/GS25/Simple.csv', index=False)


