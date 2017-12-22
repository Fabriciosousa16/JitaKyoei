package org.fpij.jitakyoei.pdsi2;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.List;

import org.fpij.jitakyoei.facade.AppFacade;
import org.fpij.jitakyoei.facade.AppFacadeImpl;
import org.fpij.jitakyoei.model.beans.Aluno;
import org.fpij.jitakyoei.model.beans.Endereco;
import org.fpij.jitakyoei.model.beans.Entidade;
import org.fpij.jitakyoei.model.beans.Filiado;
import org.fpij.jitakyoei.model.beans.Professor;
import org.fpij.jitakyoei.model.beans.ProfessorEntidade;
import org.fpij.jitakyoei.model.beans.Rg;
import org.fpij.jitakyoei.view.AppView;
import org.fpij.jitakyoei.view.MainAppView;
import org.junit.Test;

public class MeuTest {
	
	AppView view = new MainAppView();
	AppFacade facade = new AppFacadeImpl(view);
		
	@Test(expected=Exception.class)
	public void testCPFTem11DigitosInvalido() throws Exception{
		
		Filiado filiado = new Filiado();
		filiado.setCpf("12345678910");
		Aluno aluno = new Aluno();
		aluno.setFiliado(filiado);
	
		facade.createAluno(aluno);
		
	}
	
	@Test(expected=Exception.class)
	public void testCPFNullInvalido() throws Exception{
		
		String cpf = null;
		
		Filiado filiado = new Filiado();
		filiado.setCpf(cpf);
		
		Aluno aluno = new Aluno();
		aluno.setFiliado(filiado);
		
		facade.createAluno(aluno);
		
	}
	
	@Test
	public void testCPFTem11DigitosValidos() throws Exception{
		
		String cpf = "12345678910";
		Filiado filiado = new Filiado();
		filiado.setCpf(cpf);
		Aluno aluno = new Aluno();
		aluno.setFiliado(filiado);
		
		facade.createAluno(aluno);
		String cpfcadastrado = facade.searchAluno(aluno).get(0).getFiliado().getCpf();
		
		assertEquals("Não são iguais", cpf, cpfcadastrado);
		
	}
	
	@Test(expected=Exception.class)
	public void testCEPTem8DigitosInvalido() throws Exception{
		
		Endereco endereco = new Endereco();
		endereco.setCep("645000000");
		
		Filiado filiado = new Filiado();
		filiado.setEndereco(endereco);
		
		Aluno aluno = new Aluno();
		aluno.setFiliado(filiado);
		
		facade.createAluno(aluno);
			
	}
	
	@Test
	public void testCEPValido() {
		
		String cep = "64600000";
		
		Endereco endereco = new Endereco();
		endereco.setCep(cep);
		
		Filiado filiado = new Filiado();
		filiado.setEndereco(endereco);
		
		Aluno aluno = new Aluno();
		aluno.setFiliado(filiado);
		
		facade.createAluno(aluno);
		
		String cepcadastrado = facade.searchAluno(aluno).get(0).getFiliado().getEndereco().getCep();
		
		assertEquals("Não são iguais", cep, cepcadastrado);

	}
	
	@Test(expected=Exception.class)
	public void testEmailInvalido() throws Exception{
		
		String email = "fabriciosousa16";
		
		Filiado filiado = new Filiado();
		filiado.setEmail(email);
		
		Aluno aluno = new Aluno();
		aluno.setFiliado(filiado);
		
		facade.createAluno(aluno);
	}
	
	@Test(expected=Exception.class)
	public void testEmailNull() throws Exception{
		
		String email = null;
		
		Filiado filiado = new Filiado();
		filiado.setEmail(email);
		
		Aluno aluno = new Aluno();
		aluno.setFiliado(filiado);
		
		facade.createAluno(aluno);
	}
	
	
	@Test
	public void testEmailValido() throws Exception {
		
		String email = "fabriciojosedesousa@gmail.com";
		
		Filiado filiado = new Filiado();
		filiado.setEmail(email);
		
		Aluno aluno = new Aluno();
		aluno.setFiliado(filiado);
		
		facade.createAluno(aluno);

		String emailcadastrado = facade.searchAluno(aluno).get(0).getFiliado().getEmail();
		
		assertEquals("Não são iguais", email, emailcadastrado);
		
	}

	@Test(expected=Exception.class)
	public void testNomeNumeroInvalido() throws Exception {
	
	String nome = "1234567890";
		
	Filiado filiado = new Filiado();
	filiado.setNome(nome);
	
	Aluno aluno = new Aluno();
	aluno.setFiliado(filiado);
	
	facade.createAluno(aluno);
	
	}
	
	@Test(expected=Exception.class)
	public void testNomeNull() throws Exception {
	
	String nome = null;
		
	Filiado filiado = new Filiado();
	filiado.setNome(nome);
	
	Aluno aluno = new Aluno();
	aluno.setFiliado(filiado);
	
	facade.createAluno(aluno);
	
	}
	
	@Test(expected=Exception.class)
	public void testNomeSimbolo() throws Exception {
	
	String nome = "*-+%$@?";
		
	Filiado filiado = new Filiado();
	filiado.setNome(nome);
	
	Aluno aluno = new Aluno();
	aluno.setFiliado(filiado);
	
	facade.createAluno(aluno);
	
	}

	@Test
	public void testNomeValido() {
	
	String nome = "Fabricio Jose de Sousa";
	
	Filiado filiado = new Filiado();
	filiado.setNome(nome);
	
	Aluno aluno = new Aluno();
	aluno.setFiliado(filiado);
	
	facade.createAluno(aluno);
	
	String nomecadastrado = facade.searchAluno(aluno).get(0).getFiliado().getNome();
	
	assertEquals("Não são iguais", nome, nomecadastrado);
	
	}
	
	@Test(expected=Exception.class)
	public void testRuaNullInvalido() throws Exception{
		
		String rua = null;
		
		Endereco endereco = new Endereco();
		endereco.setRua(rua);
		
		Filiado filiado = new Filiado();
		filiado.setEndereco(endereco);
		
		Aluno aluno = new Aluno();
		aluno.setFiliado(filiado);
		
		facade.createAluno(aluno);	
	}
	
	@Test
	public void testRuaValido() {
		
		String rua = "Pedro Claro";
		
		Endereco endereco = new Endereco();
		endereco.setRua(rua);
		
		Filiado filiado = new Filiado();
		filiado.setEndereco(endereco);
		
		Aluno aluno = new Aluno();
		aluno.setFiliado(filiado);
		
		facade.createAluno(aluno);
		
		String ruacadastrado = facade.searchAluno(aluno).get(0).getFiliado().getEndereco().getRua();
		
		assertEquals("Não são iguais", rua, ruacadastrado);

	}
	
	@Test(expected=Exception.class)
	public void testBairroNullInvalido() throws Exception{
		
		String bairro = null;
		
		Endereco endereco = new Endereco();
		endereco.setBairro(bairro);
		
		Filiado filiado = new Filiado();
		filiado.setEndereco(endereco);
		
		Aluno aluno = new Aluno();
		aluno.setFiliado(filiado);
		
		facade.createAluno(aluno);	
	}
	
	@Test
	public void testBairroValido() {
		
		String bairro = "Centro";
		
		Endereco endereco = new Endereco();
		endereco.setBairro(bairro);
		
		Filiado filiado = new Filiado();
		filiado.setEndereco(endereco);
		
		Aluno aluno = new Aluno();
		aluno.setFiliado(filiado);
		
		facade.createAluno(aluno);
		
		String bairrocadastrado = facade.searchAluno(aluno).get(0).getFiliado().getEndereco().getBairro();
		
		assertEquals("Não são iguais", bairro, bairrocadastrado);

	}
	
	@Test(expected=Exception.class)
	public void testCidadeNullInvalido() throws Exception{
		
		String cidade= null;
		
		Endereco endereco = new Endereco();
		endereco.setCidade(cidade);
		
		Filiado filiado = new Filiado();
		filiado.setEndereco(endereco);
		
		Aluno aluno = new Aluno();
		aluno.setFiliado(filiado);
		
		facade.createAluno(aluno);	
	}
	
	@Test
	public void testCidadeValido() {
		
		String cidade = "Picos";
		
		Endereco endereco = new Endereco();
		endereco.setCidade(cidade);
		
		Filiado filiado = new Filiado();
		filiado.setEndereco(endereco);
		
		Aluno aluno = new Aluno();
		aluno.setFiliado(filiado);
		
		facade.createAluno(aluno);
		
		String cidadecadastrado = facade.searchAluno(aluno).get(0).getFiliado().getEndereco().getCidade();
		
		assertEquals("Não são iguais", cidade, cidadecadastrado);
	}
	
	@Test(expected=Exception.class)
	public void testEstadoNullInvalido() throws Exception{
		
		String estado= null;
		
		Endereco endereco = new Endereco();
		endereco.setEstado(estado);
		
		Filiado filiado = new Filiado();
		filiado.setEndereco(endereco);
		
		Aluno aluno = new Aluno();
		aluno.setFiliado(filiado);
		
		facade.createAluno(aluno);	
	}
	
	@Test
	public void testEstadoValido() {
		
		String estado = "Piaui";
		
		Endereco endereco = new Endereco();
		endereco.setEstado(estado);
		
		Filiado filiado = new Filiado();
		filiado.setEndereco(endereco);
		
		Aluno aluno = new Aluno();
		aluno.setFiliado(filiado);
		
		facade.createAluno(aluno);
		
		String estadocadastrado = facade.searchAluno(aluno).get(0).getFiliado().getEndereco().getEstado();
		
		assertEquals("Não são iguais", estado, estadocadastrado);
	}
	
	@Test(expected=Exception.class)
	public void testNumeroNullInvalido() throws Exception{
		
		String numero= null;
		
		Endereco endereco = new Endereco();
		endereco.setNumero(numero);
		
		Filiado filiado = new Filiado();
		filiado.setEndereco(endereco);
		
		Aluno aluno = new Aluno();
		aluno.setFiliado(filiado);
		
		facade.createAluno(aluno);	
	}
	
	@Test
	public void testNumeroValido() {
		
		String numero = "8555";
		
		Endereco endereco = new Endereco();
		endereco.setNumero(numero);
		
		Filiado filiado = new Filiado();
		filiado.setEndereco(endereco);
		
		Aluno aluno = new Aluno();
		aluno.setFiliado(filiado);
		
		facade.createAluno(aluno);
		
		String numerocadastrado = facade.searchAluno(aluno).get(0).getFiliado().getEndereco().getNumero();
		
		assertEquals("Não são iguais", numero, numerocadastrado);
	}
	
	@Test(expected=Exception.class)
	public void testTeleone1Invalido() throws Exception{
		
		String telefone1 = "abcdefghijklmnopqrstuvwxyz";
		
		Filiado filiado = new Filiado();
		filiado.setTelefone1(telefone1);
		Aluno aluno = new Aluno();
		aluno.setFiliado(filiado);
		
		facade.createAluno(aluno);
			
	}
	
	@Test
	public void testteleone1Valido() throws Exception{
			
			String telefone1 = "89994123086";
			
			Filiado filiado = new Filiado();
			filiado.setTelefone1(telefone1);
			
			Aluno aluno = new Aluno();
			aluno.setFiliado(filiado);
			
			facade.createAluno(aluno);
			
			String telefone1cadastrado = facade.searchAluno(aluno).get(0).getFiliado().getTelefone1();
			
			assertEquals("Não são iguais", telefone1, telefone1cadastrado);
		}
	
	@Test(expected=Exception.class)
	public void testteleone2Invalido() throws Exception{
		
		String telefone2 = "abcdefghijklmnopqrstuvwxyz";
		
		Filiado filiado = new Filiado();
		filiado.setTelefone2(telefone2);
		Aluno aluno = new Aluno();
		aluno.setFiliado(filiado);
		
		facade.createAluno(aluno);
			
	}
	
	@Test
	public void testteleone2Valido() throws Exception{
			
			String telefone2 = "89994123086";
			
			Filiado filiado = new Filiado();
			filiado.setTelefone2(telefone2);
			
			Aluno aluno = new Aluno();
			aluno.setFiliado(filiado);
			
			facade.createAluno(aluno);
			
			String telefone2cadastrado = facade.searchAluno(aluno).get(0).getFiliado().getTelefone2();
			
			assertEquals("Não são iguais", telefone2, telefone2cadastrado);
		}
	
	@Test(expected=Exception.class)
	public void testDataNascimentoInvalida(){
		
		@SuppressWarnings("deprecation")
		java.util.Date data = new java.util.Date("01/01/2030") ;
		
		Filiado filiado = new Filiado();
		filiado.setDataNascimento(data);
		
		Aluno aluno = new Aluno();
		aluno.setFiliado(filiado);
		
		facade.createAluno(aluno);
		
	}
	
	@Test
	public void testDataNascimentoValida(){
		
		@SuppressWarnings("deprecation")
		java.util.Date data = new java.util.Date("16/12/1995") ;
		
		Filiado filiado = new Filiado();
		filiado.setDataNascimento(data);
		
		Aluno aluno = new Aluno();
		aluno.setFiliado(filiado);
		
		facade.createAluno(aluno);
		
		java.util.Date datacadastrada = facade.searchAluno(aluno).get(0).getFiliado().getDataNascimento();
		assertEquals("Data de nascimento válida!", data, datacadastrada);
		
	}
	
	@Test(expected=Exception.class)
	public void testRGInvalido(){
		
		String numero = "abcdefg";
		
		Rg rg = new Rg();
		rg.setNumero(numero);
		
		Filiado filiado = new Filiado();
		filiado.setRg(rg);
		
		Aluno aluno = new Aluno();
		aluno.setFiliado(filiado);
		
		facade.createAluno(aluno);
		
	}
	
	@Test(expected=Exception.class)
	public void testRGNull(){
		
		String numero = null;
		
		Rg rg = new Rg();
		rg.setNumero(numero);
		
		Filiado filiado = new Filiado();
		filiado.setRg(rg);
		
		Aluno aluno = new Aluno();
		aluno.setFiliado(filiado);
		
		facade.createAluno(aluno);
		
	}
	
	@Test
	public void testRGValido(){
		
		String numero_rg = "3147899";
				
		Rg rg = new Rg();
		rg.setNumero(numero_rg);
		
		Filiado filiado = new Filiado();
		filiado.setRg(rg);
		
		Aluno aluno = new Aluno();
		aluno.setFiliado(filiado);
		
		facade.createAluno(aluno);
		
		String rgcadastrado = facade.searchAluno(aluno).get(0).getFiliado().getRg().getNumero();
		assertEquals("Rg válido!", numero_rg, rgcadastrado);
	}
	
	@Test(expected=Exception.class)
	public void testOrgaoExpedidorInvalido(){
		
		String orgao_expedidor = "123456";
		
		Rg rg = new Rg();
		rg.setOrgaoExpedidor(orgao_expedidor);
		
		Filiado filiado = new Filiado();
		filiado.setRg(rg);
		
		Aluno aluno = new Aluno();
		aluno.setFiliado(filiado);
		
		facade.createAluno(aluno);
		
	}
	
	@Test(expected=Exception.class)
	public void testOrgaoExpedidorNull(){
		
		String orgao_expedidor = null;
		
		Rg rg = new Rg();
		rg.setOrgaoExpedidor(orgao_expedidor);
		
		Filiado filiado = new Filiado();
		filiado.setRg(rg);
		
		Aluno aluno = new Aluno();
		aluno.setFiliado(filiado);
		
		facade.createAluno(aluno);
		
	}
	
	
	@Test
	public void testOrgaoExpedidorValido(){
		
		String orgao_expedidor = "SSP";		
		
		Rg rg = new Rg();
		rg.setOrgaoExpedidor(orgao_expedidor);
		
		Filiado filiado = new Filiado();
		filiado.setRg(rg);
		
		Aluno aluno = new Aluno();
		aluno.setFiliado(filiado);
		
		facade.createAluno(aluno);
		
		String orgao_expedidorcadastrado = facade.searchAluno(aluno).get(0).getFiliado().getRg().getOrgaoExpedidor();
		assertEquals("Rg válido!", orgao_expedidor, orgao_expedidorcadastrado);
	
	}
	
	@Test(expected=Exception.class)
	public void testObservaocaoInvalido() throws Exception {
	
	String observacao = "?+-*/";
		
	Filiado filiado = new Filiado();
	filiado.setNome(observacao);
	
	Aluno aluno = new Aluno();
	aluno.setFiliado(filiado);
	
	facade.createAluno(aluno);
	
	}

	@Test
	public void testObservacaoValido() {
	
	String observacoes = "Teste";
	
	Filiado filiado = new Filiado();
	filiado.setObservacoes(observacoes);
	
	Aluno aluno = new Aluno();
	aluno.setFiliado(filiado);
	
	facade.createAluno(aluno);
	
	String observacoescadastrado = facade.searchAluno(aluno).get(0).getFiliado().getObservacoes();
	
	assertEquals("Não são iguais", observacoes, observacoescadastrado);
	
	}
	
	@Test(expected=Exception.class)
	public void testCodigoInvalido() throws Exception {
	
	String codigo = "?+-*";
		
	Filiado filiado = new Filiado();
	filiado.setRegistroCbj(codigo);
	
	Aluno aluno = new Aluno();
	aluno.setFiliado(filiado);
	
	facade.createAluno(aluno);
	
	}

	@Test
	public void testCodigoCBJValido() {
	
	String codigo = "20148963214";
	
	Filiado filiado = new Filiado();
	filiado.setRegistroCbj(codigo);
	
	Aluno aluno = new Aluno();
	aluno.setFiliado(filiado);
	
	facade.createAluno(aluno);
	
	String codigocadastrado = facade.searchAluno(aluno).get(0).getFiliado().getRegistroCbj();
	
	assertEquals("Não são iguais", codigo, codigocadastrado);
	
	}
	
}