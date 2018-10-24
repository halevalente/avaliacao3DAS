package Cadastros;


public class GetDuracaoHoras {
	
	private final Viagem _viagem;
	private int duracaoHoras;
	private int horaTermino;
	private int horaInicio;
	private int minutosTermino;
	private int minutosInicio;
	
	GetDuracaoHoras(Viagem source, int horaTermino, int horaInicio, int minutosTermino, int minutosInicio){
		_viagem = source;
		this.horaTermino = horaTermino;
		this.horaInicio = horaInicio;
		this.minutosTermino = minutosTermino;
		this.minutosInicio = minutosInicio;
		
	}
	

	public int calcular() {
		if (horaTermino == horaInicio)
			setDuracaoHoras(0);
		if (horaTermino > horaInicio) //varias possibilidades... 
			if (horaTermino == adicionar(horaInicio, 1)) {  
				if (minutosTermino < minutosInicio)  //nao chegou a uma hora
					setDuracaoHoras(0);
				else //durou pelo menos uma hora
					setDuracaoHoras(1);
			} else { //possivelmente ultrapassou duas horas
				if (subtrair(horaTermino, horaInicio) > 2) //
					setDuracaoHoras(subtrair(horaTermino, horaInicio));
				else if (subtrair(horaTermino, horaInicio) == 2 &&   //certamente menos de duas horas  
						 minutosTermino < minutosInicio)    //e mais de uma hora
					setDuracaoHoras(1);
				else //duracao de duas horas, certamente
					setDuracaoHoras(2);
					
			}
		if (horaTermino < horaInicio) 
			setDuracaoHoras(-1); //para casos em que a hora de termino nao foi registrada
		return duracaoHoras;
	}
	
	public int subtrair(int arg1, int arg2) {
		return arg1-arg2;
	}
	
	public int adicionar(int arg1, int arg2) {
		return arg1+arg2;
	}
	
	void setDuracaoHoras(int duracao){
		duracaoHoras = duracao;
	}
	
	
}
