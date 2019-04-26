package co.esampio.rest.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import co.esampio.repo.entity.entities.InformacionTarjetaEntity;
import co.esampio.util.dto.InformacionTarjetaDTO;

@Configuration
public class MapperConfig {
	
	@Bean(name = "genericMapper")
	@Primary
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
	
	@Bean(name = "mapperFactura")
	public ModelMapper getModelMapperConsultaUsuario() {
		PropertyMap<InformacionTarjetaEntity, InformacionTarjetaDTO> map = new PropertyMap<InformacionTarjetaEntity, InformacionTarjetaDTO>() {
			@Override
			protected void configure() {
//					map().setProductos(source.getProducto());
			}
		};
		ModelMapper aux = new ModelMapper();
		aux.addMappings(map);		
		return aux; 
	}
//	@Bean(name = "mapperProducto")
//	public ModelMapper getModelMapperConsultaProducto() {
//		PropertyMap<Producto, ProductoDTO> map = new PropertyMap<Producto, ProductoDTO>() {
//			@Override
//			protected void configure() {
////			skip().setFacturas(null);
//			}
//		};
//		ModelMapper aux = new ModelMapper();
//		aux.addMappings(map);		
//		return aux; 
//	}
}
