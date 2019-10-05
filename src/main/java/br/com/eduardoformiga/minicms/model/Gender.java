package br.com.eduardoformiga.minicms.model;

public enum Gender {

	FEMININO(0, "Feminino"),
	MASCULINO(1, "Masculino");

	private Integer codigo;
	private String descricao;

	Gender(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
