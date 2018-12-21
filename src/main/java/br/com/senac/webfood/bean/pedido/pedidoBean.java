
package br.com.senac.webfood.bean.pedido;

import br.com.senac.webfood.banco.ClienteDAO;
import br.com.senac.webfood.banco.ComplementoDAO;
import br.com.senac.webfood.banco.ProdutoDAO;
import br.com.senac.webfood.banco.PedidoDAO;
import br.com.senac.webfood.bean.Bean;
import br.com.senac.webfood.modelo.Cliente;
import br.com.senac.webfood.modelo.Complemento;
import br.com.senac.webfood.modelo.ItemDePedido;
import br.com.senac.webfood.modelo.Pedido;
import br.com.senac.webfood.modelo.Produto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author sala306b
 */
@Named(value = "pedidoBean")
@ViewScoped
public class pedidoBean extends Bean {
    private final PedidoDAO dao = new PedidoDAO();
    private final ClienteDAO daoCliente = new ClienteDAO();
    private final ComplementoDAO daoComplemento= new ComplementoDAO();
    private final ProdutoDAO daoProdutoDAO = new ProdutoDAO();
    private Pedido pedido = new Pedido();
    private Produto produtoSelecionado = new Produto();
    private final Complemento complemento=new Complemento();
    private int quantidade;
    
    private List<Complemento> listaComplemento ; 

    private double preco;
    private long idt ;

    public pedidoBean() {
    }

    public Pedido getPedido() {
        return pedido;
    }

    public List<Complemento> getListaComplemento() {
        return listaComplemento;
    }

    public void setListaComplemento(List<Complemento> listaComplemento) {
        this.listaComplemento = listaComplemento;
    }
    
    
    

    
    
  public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Produto getProdutoSelecionado() {
        return produtoSelecionado;
    }

    public void setProdutoSelecionado(Produto produtoSelecionado) {
        this.produtoSelecionado = produtoSelecionado;
    }

    public List<Cliente> sugerirClientes(String consulta) {
        return daoCliente.findByNome(consulta);
    }

    public void pesquisaClienteId() {
        Cliente cliente = null;
        cliente = daoCliente.find(pedido.getCliente().getId());
        if (cliente != null) {
            this.pedido.setCliente(cliente);
        } else {
            this.pedido.setCliente(new Cliente());
            addMessageWarnnig("Nao encontrado cliente para o codigo.");
        }
        
        

    }
    
   

    public void handleSelectProduto() {
        this.preco = this.produtoSelecionado.getPrecoPadrao();
    }
    

    public List<Produto> sugerirProdutos(String consulta) {
        return daoProdutoDAO.findByNome(consulta);
    }

    public void pesquisaProdutoId() {
        Produto produto = null;
        produto = daoProdutoDAO.find(produtoSelecionado.getId());
        if (produto != null) {
            this.produtoSelecionado = produto;
            this.preco = produto.getPrecoPadrao();
        } else {
            this.produtoSelecionado = new Produto();
            addMessageWarnnig("Nao encontrado Produto para o codigo.");
        }

    }

    public List<Integer> getParcelas() {
        List<Integer> parcelas = new ArrayList<>();

        for (int i = 1; i <= this.pedido.getFormaPagamento().getQuantidadeMaximaParcela(); i++) {
            parcelas.add(i);
        }

        return parcelas;
    }
    
    public List<Complemento> getListaComplementos(){
        return daoComplemento.findAllAtivo();
    }

    public void addProduto() {

        if (produtoSelecionado.getId() != 0 && quantidade > 0 && preco > 0) {
            ItemDePedido itemDePedido = new ItemDePedido(produtoSelecionado, quantidade, preco , listaComplemento);
            this.pedido.add(itemDePedido);

            this.limparPesquisaProduto();
        } else {
            addMessageError("Favor selecionar Produto.");
        }
        
         
        this.pedido.setId(idt++);

    }
    
     public String editar(){
        return "/admin/Pedido/pedido";
    }

    private void limparPesquisaProduto() {

        this.produtoSelecionado = new Produto();
        this.quantidade = 0;
        this.preco = 0;
    }

   public String salvar() {

        try {

            if (this.pedido.getId() == 0) {
                //dao.save(pedido);
                addMessageInfo("Salvo com sucesso !");
            } else {
               // dao.update(pedido);
                addMessageInfo("Alterado com sucesso !");
            }

        } catch (Exception ex) {
            addMessageError(ex.getMessage());
        }
        
       this.pedido.setId(++idt);

        return null;
    }
   
   @PostConstruct
   public void init(){
       this.idt = 4 ; 
   }
    
    
}
