### _Chapter 06: Class Design_

---
#### `Notlar`
1. **abstract** ve **private**, **static** ve **final** anahtar kelimeleri birlikte kullanılamaz.
2. _Overloaded instance methodlar_ ve _hidden static methodlar_ aynı method imzasına sahip olmak zorundadırlar. 
3. _Overriden_ ve _hidden_ methodlar aynı veya _covariant_ dönüş tipine sahip olabilirler.
4. _Override_ edilen method yeni bir _checked exception_ veya devralınan methoddan daha daha geniş (_broader exception_)
   bir istisna fırlatamaz.
5. _Overriden_ methodlar aynı veya daha yüksek _access modifier_'a sahip olabilirler.
6. Instance değişkenler _override_ edilemezler. Sadece _hidening_ yapılabilir.
7. Static methodlar _override_ edilemezler. Sadece _hidening_ yapılabilir.
