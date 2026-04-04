package br.com.gabrielbcunha.controleestoquespringboot.repository;

import br.com.gabrielbcunha.controleestoquespringboot.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
