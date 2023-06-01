package br.com.A3.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.A3.models.Categoria;
import br.com.A3.models.Produto;
import br.com.A3.repository.CategoriaRepository;
import br.com.A3.repository.ProdutoRepository;

@Controller
public class CategoriaController {


	@Autowired
	private CategoriaRepository repository;
	
	@Autowired
	private ProdutoRepository pRepository;

	@RequestMapping(value = "/cadastrarCategoria", method = RequestMethod.GET)
	public String form() {
		return "categoria/formCategoria";
	}

	//CADASTRO + VALIDATION
	@RequestMapping(value = "/cadastrarCategoria", method = RequestMethod.POST)
	public String form(@Valid Categoria categoria, BindingResult result, RedirectAttributes attributes) {

		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/cadastrarCategoria";

		}
		
		repository.save(categoria);
		attributes.addFlashAttribute("mensagem", "Categoria cadastrada com sucesso!");
		return "redirect:/cadastrarCategoria";
	}

	// Metodo para Busca lista no Banco de dados e renderizar na PAG.
	@RequestMapping("/categorias")
	public ModelAndView listaCategorias() {
		ModelAndView mv = new ModelAndView("cadastro");
		Iterable<Categoria> categorias = repository.findAll();
		mv.addObject("categorias", categorias);
		return mv;
	}
	
	@RequestMapping(value="/{codigo}", method=RequestMethod.GET)
	public ModelAndView detalhesCategoria(@PathVariable("codigo") long codigo) {
		Categoria categoria = repository.findByCodigo(codigo);
		ModelAndView mv = new ModelAndView("categoria/detalhesCategoria");
		mv.addObject("categoria" , categoria);
		Iterable<Produto> produtos = pRepository.findByCategoria(categoria);
		mv.addObject("produtos", produtos);
		return mv;
	}
	
	@RequestMapping("/deletarCategoria")
	public String deletarCategoria(long codigo) {
		Categoria categoria = repository.findByCodigo(codigo);
		repository.delete(categoria);
		return "redirect:/categorias";
	}

	//VALIDATION
	@RequestMapping(value="/{codigo}", method=RequestMethod.POST)
	public String detalhesCategoriaPost(@PathVariable("codigo") long codigo, @Valid Produto produto, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/{codigo}";
			
		}
		
		Categoria categoria = repository.findByCodigo(codigo);
		produto.setCategoria(categoria);
		pRepository.save(produto);
		attributes.addFlashAttribute("mensagem", "Produto adcionado com sucesso!");
		return "redirect:/{codigo}";
	}
	
	
	  @RequestMapping("/deletarProduto") public String deletarProduto(String
	  produto1) { Produto produto = pRepository.findByProduto1(produto1);
	  pRepository.delete(produto);
	 
	  Categoria categoria = produto.getCategoria(); 
	  long codigoLong = categoria.getCodigo(); 
	  String codigo = "" + codigoLong; 
	  return "redirect:/" + codigo; 
	  }
	/*
	 * @GetMapping public List<Categoria> findAll() { return repository.findAll(); }
	 * 
	 * 
	 * @GetMapping(value = "/{id}") public Categoria findAll(@PathVariable Long id)
	 * { return repository.findById(id).get(); }
	 * 
	 * @PostMapping public Categoria insert(@RequestBody Categoria categoria) {
	 * return repository.save(categoria); }
	 */

	

}
