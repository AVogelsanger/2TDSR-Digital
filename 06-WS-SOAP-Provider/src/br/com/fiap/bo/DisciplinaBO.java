package br.com.fiap.bo;

public class DisciplinaBO {

	public float calcularMedia(float nac, float ps, float am) {
		return nac*0.2f + ps*0.5f + am*0.3f;  
	}
	
	public float calcularNotaExame(float media) {
		return 12f - media;
	}
	
	public boolean retidoFalta(int aulas, int faltas) {
		return aulas * 0.25 < faltas;
	}
	
}
