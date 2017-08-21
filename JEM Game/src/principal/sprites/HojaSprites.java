package principal.sprites;

import java.awt.image.BufferedImage;

import principal.herramientas.CargadorRecursos;

public class HojaSprites {
	final private int anchoHojaPixeles;
	final private int altoHojaPixeles;
	
	final private int anchoHojaEnSprites;
	final private int altoHojaEnSprites;
	
	final private int anchoSprite;
	final private int altoSprite;
	
	final private Sprite[] sprite;
	
	public HojaSprites(final String ruta, final int tamañoSprite, final boolean hojaOpaca){
		BufferedImage imagen;
		
		if(hojaOpaca){
			imagen = CargadorRecursos.cargarImagenCompatibleOpaca(ruta);
		}else{
			imagen = CargadorRecursos.cargarImagenCompatibleTranslucida(ruta);
		}
		
		anchoHojaPixeles = imagen.getWidth();
		altoHojaPixeles = imagen.getHeight();
	
		anchoHojaEnSprites = anchoHojaPixeles / tamañoSprite;
		altoHojaEnSprites = altoHojaPixeles / tamañoSprite;

		this.anchoSprite = tamañoSprite;
		this.altoSprite = tamañoSprite;
		
		sprite = new Sprite[anchoHojaEnSprites * altoHojaEnSprites];
		
		rellenarSpritesDesdeImagen(imagen);
	}
	
	public HojaSprites(final String ruta, final int anchoSprite, final int altoSprite, final boolean hojaOpaca){
		BufferedImage imagen;
		
		if(hojaOpaca){
			imagen = CargadorRecursos.cargarImagenCompatibleOpaca(ruta);
		}else{
			imagen = CargadorRecursos.cargarImagenCompatibleTranslucida(ruta);
		}
		
		anchoHojaPixeles = imagen.getWidth();
		altoHojaPixeles = imagen.getHeight();
	
		anchoHojaEnSprites = anchoHojaPixeles / anchoSprite;
		altoHojaEnSprites = altoHojaPixeles / altoSprite;

		this.anchoSprite = anchoSprite;
		this.altoSprite = altoSprite;
		
		sprite = new Sprite[anchoHojaEnSprites * altoHojaEnSprites];
	
		rellenarSpritesDesdeImagen(imagen);
	}
	
	private void rellenarSpritesDesdeImagen(final BufferedImage imagen){
		for(int y = 0; y < altoHojaEnSprites;y++){
			for(int x = 0; x < anchoHojaEnSprites;x++){
				final int posicionX = x * anchoSprite;
				final int posicionY = y * altoSprite;
				
				sprite[x+y*anchoHojaEnSprites] = new Sprite(imagen.getSubimage(posicionX, posicionY, anchoSprite, altoSprite));
			}
		}
	}
	
	public Sprite obtenerSprite(final int indice){
		return sprite[indice];
	}
	
	public Sprite obtenerSprite(final int x, final int y){
		return sprite[x + y * anchoHojaEnSprites];
	}
}
