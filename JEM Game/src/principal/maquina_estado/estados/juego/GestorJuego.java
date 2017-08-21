package principal.maquina_estado.estados.juego;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import principal.herramientas.CargadorRecursos;
import principal.maquina_estado.EstadoJuego;
import principal.sprites.HojaSprites;

public class GestorJuego implements EstadoJuego{

	private GestorMapa gestorMapa;
	HojaSprites hs = new HojaSprites("/imagenes/hojasTexturas/sofrecom.png",32,true);
	
	String texto = CargadorRecursos.leerArchivoTexto("/texto/prueba");
	
	@Override
	public void actualizar() {
		
	}

	@Override
	public void dibujar(Graphics g) {
	/*	BufferedImage imagen = hs.obtenerSprite(0, 0).obtenerImagen();
		g.drawImage(imagen,100,100,null);
	*/
		g.setColor(Color.white);
		g.drawString(texto, 10, 10);
	}

}
