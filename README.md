# M2_HomeWork_Shop

### Zaimplementuj sklep internetowy, który oferuje 3 warianty.

- [x] Podstawową funkcjonalnością jaką posiada każdy sklep jest wariant „START”. 
  * Umożliwia on na dodawanie produktów do koszyka (produkt przechowuje nazwę i cenę), 
  * oraz na ich podstawie wypisywać na oknie konsoli cenę wszystkich produktów.
- [X] Pakiet „PLUS”
  * dodatkowo umożliwia doliczenie do ceny wynikowej podatku VAT. 
  * Stawka podatku VAT ma zostać uwzględniona w pliku konfiguracyjnym.
- [x] Pakiet „PRO” 
  * oprócz wyliczania podatku
  * ma również możliwość wyliczenia rabatu, 
  którego wartość jest uwzględniona w pliku konfiguracyjnym.

- [x] Aplikacja na start dodaje 5 dowolnych produktów z losowaną ceną (w przedziale 50-300 zł) 
   * i wyświetla ich sumaryczną cenę.

Dodatkowo:
- [x] zamiana dziedziczenia na kompozycje
- [x] testy BASIC




###OUTPUT:
****************************
You are in BASIC Shop
TOTAL price= SumPrice

Product(name=book1, price=174.19)
Product(name=book2, price=129.11)
Product(name=book3, price=289.41)
Product(name=book4, price=156.27)
Product(name=book5, price=231.56)
TOTAL price = 980.54
***********************************

You are in PLUS Shop
TOTAL price= SumPrice*TAX

Product(name=book1, price=168.77)
Product(name=book2, price=116.19)
Product(name=book3, price=141.27)
Product(name=book4, price=236.16)
Product(name=book5, price=195.93)
TOTAL price = 1038.57

***********************************
You are in PRO Shop
TOTAL price= SumPrice*TAX-discount

Product(name=book1, price=169.05)
Product(name=book2, price=181.27)
Product(name=book3, price=274.31)
Product(name=book4, price=242.19)
Product(name=book5, price=235.38)
TOTAL price = 1266.98