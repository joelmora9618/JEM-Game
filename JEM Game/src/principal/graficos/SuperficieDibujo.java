package principal.graficos;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

import principal.control.Teclado;
import principal.maquina_estado.GestorEstados;

public class SuperficieDibujo extends Canvas{
	
	private static final long serialVersionUID = -6227038142688953660L;

	private int ancho;
	private int alto;
	
	private Teclado teclado;
	
	public SuperficieDibujo(final int ancho, final int alto){
		this.ancho = ancho;
		this.alto = alto;
		
		teclado = new Teclado();
		
		setIgnoreRepaint(true);
		setPreferredSize(new Dimension(ancho, alto));
		addKeyListener(teclado);
		setFocusable(true);
		requestFocus();
	}
	
	public void dibujar(final GestorEstados ge){
		BufferStrategy buffer = getBufferStrategy();
		
		if(buffer == null){
			createBufferStrategy(3);
			return;
		}
		Graphics g = buffer.getDrawGraphics();
		
		g.setColor(Color.BLACK);
		g.fillRect(0,0,ancho, alto);
		
		ge.dibujar(g);
		
		Toolkit.getDefaultToolkit().sync();
		
		g.dispose();
		
		buffer.show();
	}
	
	public Teclado obtenerTeclado(){
		return teclado;
	}
	
	public int obtenerAncho(){
		return ancho;
	}
	public int obtenerAlto(){
		return alto;
	}
}
