package br.com.edson.prime.inscricao.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edson.prime.inscricao.model.PedidoOracao;
import br.com.edson.prime.inscricao.repository.PedidoOracaoRepository;

@Service
public class PedidoOracaoService {

	
	
	@Autowired
	private PedidoOracaoRepository pedidoRepository;
	
	
	
	
	
	
	
	

	
public List<PedidoOracao> getAll() {
		
		List<PedidoOracao> list =  pedidoRepository.findAll();
		
		return list;
		
	}

	
public PedidoOracao getById(Integer id) {
		
		Optional<PedidoOracao> Omot =  pedidoRepository.findById(id);
		
		if(Omot.isPresent())
		{
			return Omot.get();
		}else {
			return new PedidoOracao();
		}
	}
	


@Transactional
public boolean delete(Integer id) {
		
		Optional<PedidoOracao> Omot =  pedidoRepository.findById(id);
		
		if(Omot.isPresent())
		{
			pedidoRepository.delete(Omot.get());
			return true;
		}else {
			return false;
		}
	}
	



@Transactional
public PedidoOracao save(PedidoOracao dto) {
	
	

		PedidoOracao PedidoOracaoSaved =     pedidoRepository.save(dto);
		
		
		return PedidoOracaoSaved;
		
	
}
	
	
}
