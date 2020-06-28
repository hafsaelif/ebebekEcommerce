package com.ebebek.services;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.ebebek.models.Product;

@Service
public class ProductService {

	public List<Product> getAllProducts() {

		ArrayList<Product> listOfProduct = new ArrayList<>();

		listOfProduct.add(new Product("1", "Renkli Anahtarlar",
				"Bebeklik döneminde duyusal gelişimini desteklemek için tasarlanmıştır.", "product6", 20.00));
		listOfProduct.add(new Product("2", "Kanz Pır Pır Uçak",
				"Kanz Pırpır Uçak, miniklerin güvenle eğlenerek oynayabilecekleri bir aktivite oyuncağıdır.",
				"product2", 29.00));
		listOfProduct.add(new Product("3", "Akıllı Küpler",
				"Rengarenk şekiller ilgisini çeken Bul-Tak, hem eğitici hem de eğlendirici bir oyuncaktır.",
				"product3", 14.00));
		listOfProduct.add(new Product("4", "Pastalı Çay Seti",
				"Kızların evcilik oyunları için harika bir set, küçük hanımların artık kendi çay setleri var.",
				"product4", 19.00));
		listOfProduct.add(new Product("5", "Pilsan Araba Asortili",
				"4 Adet değişik model ve renk seçeneği ile minik araba", "product5", 24.00));
		listOfProduct.add(new Product("6", "Play-Doh No 3 Hamur 4'lü",
				"Klasik ya da alternatif renk çeşitleriyle 448 gram oyun hamuru dört kutuda...", "product1", 17.00));
		listOfProduct.add(new Product("7", "Cuf Cuf Tren",
				"Miniklerin güvenle eğlenerek oynayabilecekleri bir aktivite oyuncağıdır.", "product7", 50.00));
		listOfProduct.add(new Product("8", "Oyuncu Fil Asortili",
				"30 cm uzunluğundaki Babycim Ce ee Oyuncu Fil ile eğlenceli oyun zamanı!", "product8", 99.00));

		return listOfProduct;

	}
	
	//find product
	public Product getProductById(String id) {

		Predicate<Product> byId = p -> p.getId().equals(id);
		return filterProducts(byId);

	}

	public Product filterProducts(Predicate<Product> strategy) {
		
		return getAllProducts().stream().filter(strategy).findFirst().orElse(null);
	}

}
