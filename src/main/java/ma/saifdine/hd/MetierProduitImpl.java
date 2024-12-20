package ma.saifdine.hd;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MetierProduitImpl implements IMetier<Produit>{

    private List<Produit> produits = new ArrayList<Produit>();

    @Override
    public void add(Produit o) {
        produits.add(o);
    }

    @Override
    public List<Produit> getAll() {
        return produits;
    }

    @Override
    public Produit findById(Long id) {
        for (Produit p : produits) {
            if (Objects.equals(p.getId(), id)){
                return p;
            }
        }
        return null;
    }

    @Override
    public void delete(long id) {
        produits.remove(findById(id));
    }
}
