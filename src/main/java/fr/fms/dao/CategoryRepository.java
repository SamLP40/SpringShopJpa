package fr.fms.dao;
import java.util.List;

import javax.persistence.OrderBy;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.fms.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
// Méthode qui va chercher les noms de catégories en base (smartphone, phone, iphone, garbage)
	@OrderBy
	public List <Category> findByName(String name);
}
 
