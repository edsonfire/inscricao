package br.com.edson.prime.inscricao.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edson.prime.inscricao.model.Videos;
import br.com.edson.prime.inscricao.repository.VideosRepository;

@Service
public class VideosService {

	
	
	@Autowired
	private VideosRepository videosRepository;
	
	
	
	
	
	
	
	

	
public List<Videos> getAll() {
		
		List<Videos> list =  videosRepository.findAll();

		
	//	Videoss = list.stream().map(x-> new VideosDTO(x)).collect(Collectors.toList());
		
		return list;
		
	}

	
public Videos getById(Integer id) {
		
		Optional<Videos> Omot =  videosRepository.findById(id);
		
		if(Omot.isPresent())
		{
			return Omot.get();
		}else {
			return new Videos();
		}
	}
	


@Transactional
public boolean delete(Integer id) {
		
		Optional<Videos> Omot =  videosRepository.findById(id);
		
		if(Omot.isPresent())
		{
			videosRepository.delete(Omot.get());
			return true;
		}else {
			return false;
		}
	}
	




@Transactional
public Videos update(Videos dto) {
		
		Optional<Videos> Omot =  videosRepository.findById(dto.getId());
		
		
		
		
		if(Omot.isPresent())
		{
			Videos mot = Omot.get();
			
			mot.setDescricao(dto.getDescricao());
			mot.setData(dto.getData());
			mot.setAtivo(dto.getAtivo());
					
			
			videosRepository.save(mot);
			return mot;
		}else {
			return new Videos();
		}
	}





@Transactional
public Videos save(Videos dto) {
	
	

		Videos VideosSaved =     videosRepository.save(dto);
		
		
		return VideosSaved;
		
	
}
	
	
}
