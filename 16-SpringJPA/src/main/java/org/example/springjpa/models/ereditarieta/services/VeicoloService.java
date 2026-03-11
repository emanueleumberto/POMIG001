package org.example.springjpa.models.ereditarieta.services;

import org.example.springjpa.models.ereditarieta.models.Automobile;
import org.example.springjpa.models.ereditarieta.models.Camper;
import org.example.springjpa.models.ereditarieta.models.Moto;
import org.example.springjpa.models.ereditarieta.models.Veicolo;
import org.example.springjpa.models.ereditarieta.repositories.VeicoloDAORepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeicoloService {

    @Autowired VeicoloDAORepository veicoloDB;
    @Autowired @Qualifier("creaAutomobile") ObjectProvider<Automobile> creaAutomobileProvider;
    @Autowired @Qualifier("creaMoto") ObjectProvider<Moto> creaMotoProvider;
    @Autowired @Qualifier("creaCamper") ObjectProvider<Camper> creaCamperProvider;

    public Automobile creaAutomobile(String marca, String modello, String targa, Integer numPorte){
        Automobile auto =  creaAutomobileProvider.getObject();
        auto.setMarca(marca);
        auto.setModello(modello);
        auto.setTarga(targa);
        auto.setNumPorte(numPorte);
        return  auto;
    }
    public Moto creaMoto(String marca, String modello, String targa, Integer numPosti){
        Moto moto =  creaMotoProvider.getObject();
        moto.setMarca(marca);
        moto.setModello(modello);
        moto.setTarga(targa);
        moto.setNumPosti(numPosti);
        return  moto;
    }
    public Camper creaCamper(String marca, String modello, String targa, Integer numLetti){
        Camper camper =  creaCamperProvider.getObject();
        camper.setMarca(marca);
        camper.setModello(modello);
        camper.setTarga(targa);
        camper.setNumLetti(numLetti);
        return  camper;
    }

    public void saveVeicolo(Veicolo veicolo){
        veicoloDB.save(veicolo);
        System.out.println("Veicolo " + veicolo.getMarca() + " " + veicolo.getModello() + " salvato con sucesso!");
    }

    public Veicolo findVeicolo(long id){
        return veicoloDB.findById(id).get();
    }

    public void updateVeicolo(Veicolo veicolo){
        veicoloDB.save(veicolo);
        System.out.println("Veicolo " + veicolo.getMarca() + " " + veicolo.getModello() + " modificato con sucesso!");
    }

    public void removeVeicolo(Veicolo veicolo){
        veicoloDB.delete(veicolo);
        System.out.println("Veicolo " + veicolo.getMarca() + " " + veicolo.getModello() + " eliminato con sucesso!");
    }

    public List<Veicolo> findAllVeicolo(){
        return veicoloDB.findAll();
    }

    public boolean existsTarga(String targa){
        return veicoloDB.existsByTarga(targa);
    }
}
