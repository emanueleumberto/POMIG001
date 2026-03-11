package org.example.gestionepizzeriajpa.services;

import org.example.gestionepizzeriajpa.models.Cliente;
import org.example.gestionepizzeriajpa.repositories.ClientiDAORepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ClientiService {

    @Autowired @Qualifier("creaCliente") ObjectProvider<Cliente> creaClienteObjectProvider;
    @Autowired @Qualifier("creaClienteFake") ObjectProvider<Cliente> creaClienteFakeObjectProvider;
    @Autowired ClientiDAORepository clientiDB;

    public Cliente creaCliente(String nome, String telefono) {
        Cliente cliente = creaClienteObjectProvider.getObject();
        cliente.setNome(nome);
        cliente.setTelefono(telefono);
        return cliente;
    }

    public Cliente creaClienteFake() {
        return creaClienteFakeObjectProvider.getObject();
    }

    public void salvaCliente(Cliente cliente) {
        clientiDB.save(cliente);
        System.out.println("Cliente: " + cliente.getNome() + " salvato nel DB!");
    }

    public Cliente leggiCliente(long id) {
        return clientiDB.findById(id).get();
    }

    public void eliminaCliente(Cliente cliente) {
        clientiDB.delete(cliente);
        System.out.println("Cliente: " + cliente.getNome() + " eliminato dal DB!");
    }
}
