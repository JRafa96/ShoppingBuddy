import bs4 as bs
import sys
import MySQLdb
from PyQt5.QtWebEngineWidgets import QWebEnginePage
from PyQt5.QtWidgets import QApplication
from PyQt5.QtCore import QUrl


class Database:
    host = 'localhost'
    user = 'root'
    password = ''
    db = 'android_api'

    def __init__(self):
        self.connection = MySQLdb.connect(self.host, self.user, self.password, self.db)
        self.cursor = self.connection.cursor()

    def insert(self, query):
        try:
            self.cursor.execute(query)
            self.connection.commit()
        except:
            self.connection.rollback()

    def query(self, query):
        cursor = self.connection.cursor(MySQLdb.cursors.DictCursor)
        cursor.execute(query)

        return cursor.fetchall()

    def __del__(self):
        self.connection.close()


class Page(QWebEnginePage):
    def __init__(self, url):
        self.app = QApplication(sys.argv)
        QWebEnginePage.__init__(self)
        self.html = ''
        self.loadFinished.connect(self._on_load_finished)
        self.load(QUrl(url))
        self.app.exec_()

    def _on_load_finished(self):
        self.html = self.toHtml(self.Callable)

    def Callable(self, html_str):
        self.html = html_str
        self.app.quit()


def convertPostoName(posto):
    switcher = {
        "Galp - Pernes": 1,
        "Galp Santarém": 2,
        "Galp - J.M.Cordeiro, Lda - N/S": 3,
        "Galp - J.M.Cordeiro, Lda - S/N": 4,
        "BP - A1 Santarém S/N": 5,
        "BP - A1 Santarém N/S": 6,
        "Prio - Alcanhões": 7,
        "BP - Pé da Pedreira": 8,
        "Repsol - Pernes": 9,
        "BP - Santarém": 10,
        "Repsol - S. Pedro - Santarém": 11,
        "Repsol - Santarém": 12,
        "Pingo Doce - Santarém": 13,
        "E.Leclerc - Santarém": 14,
        "Gasprocar - Santarém": 15
    }
    return switcher.get(posto, "Posto invalido")


def scraping(lista):
    db = Database()
    for item in lista:
        name = item.find('div', class_='name').text.split('Actualizado')[0]
        temp = item.findAll('div', class_='price')
        postoId = convertPostoName(name)

        for y in range(0, len(temp)):
            if bool(temp[y].find('div', class_='encoded')):
                data = temp[y].text.split('€')
                tipo = data[0]
                tipo = tipo.replace("+","Plus")
                price = data[1]
                if "actualizado" in price:
                    price = price.split('Preço')[0]
                db.insert("INSERT INTO `precoscombustivel` (`posto_Id`, `tipo`, `preço`) VALUES ('%s', '%s', '%s')" % (
                postoId, tipo, price))
                print("Posto " + name + " id= " + str(postoId) + " tem " + tipo + " a " + price + " euros")


def main():
    db = Database()
    db.query("TRUNCATE TABLE precoscombustivel")
    page1 = Page('https://www.maisgasolina.com/lista-de-postos/santarem/santarem/')
    page2 = Page('https://www.maisgasolina.com/lista-de-postos/santarem/santarem/2/')
    soup1 = bs.BeautifulSoup(page1.html, 'lxml')
    soup2 = bs.BeautifulSoup(page2.html, 'lxml')
    lista1 = soup1.find(id="stationList").findAll('a')
    lista2 = soup2.find(id="stationList").findAll('a')

    scraping(lista1)
    scraping(lista2)


if __name__ == '__main__': main()
