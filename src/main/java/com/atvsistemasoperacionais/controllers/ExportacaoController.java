package com.atvsistemasoperacionais.controllers;

import com.atvsistemasoperacionais.DTOs.UsuarioCreateDTO;
import com.atvsistemasoperacionais.Services.UsuarioService;
import com.atvsistemasoperacionais.entities.Documento;
import com.atvsistemasoperacionais.entities.Endereco;
import com.atvsistemasoperacionais.entities.Usuario;
import com.atvsistemasoperacionais.repositorys.DocumentoRepository;
import com.atvsistemasoperacionais.repositorys.EnderecoRepository;
import com.atvsistemasoperacionais.repositorys.UsuarioRepository;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.DocumentHandler;

import java.awt.*;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/exportar")
public class ExportacaoController {

    @Autowired
    private UsuarioRepository Usuariorepository;

    @Autowired
    private EnderecoRepository EnderecoRepository;

    @Autowired
    private DocumentoRepository DocumentoRepository;

    @GetMapping("/json")
    public ResponseEntity<List<Usuario>> downloadFileJSON () {
        List<Usuario> lista = Usuariorepository.findAll();

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"usuarios.json\"")
                .contentType(MediaType.APPLICATION_JSON)
                .body(lista);
    }

    @GetMapping("/csv")
    public ResponseEntity<String> downloadFileCSV (){
        List<Endereco> list = EnderecoRepository.findAll();
        StringBuilder csvBuilder = new StringBuilder();
        csvBuilder.append("ID;ID do Usuário;CEP;UF;Cidade;Bairro;Número;Complemento\n");
        for (Endereco end : list) {
            csvBuilder.append(end.getId()).append(";");
            csvBuilder.append(end.getId_usuario()).append(";");
            csvBuilder.append(end.getCep()).append(";");
            csvBuilder.append(end.getUf()).append(";");
            csvBuilder.append(end.getCidade()).append(";");
            csvBuilder.append(end.getBairro()).append(";");
            csvBuilder.append(end.getNumero()).append(";");
            csvBuilder.append(end.getComplemento()).append("\n");
        }

        String nomeArquivo = "enderecos.csv";

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + nomeArquivo)
                .contentType(MediaType.parseMediaType("text/csv"))
                .body(csvBuilder.toString());

    }

    @GetMapping("/pdf")
    public void exportarParaPdf(HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=relatorio_documentos.pdf";
        response.setHeader(headerKey, headerValue);
        List<Documento> list = DocumentoRepository.findAll();

        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();

        Font fontTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontTitulo.setSize(18);
        fontTitulo.setColor(Color.BLACK);

        Paragraph titulo = new Paragraph("Relatório de Documentos", fontTitulo);
        titulo.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(titulo);

        document.add(new Paragraph(" "));

        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.5f, 3.0f});
        table.setSpacingBefore(10);

        escreverCabecalhoTabela(table);
        escreverDadosTabela(table, list);
        document.add(table);
        document.close();


    }
    private void escreverCabecalhoTabela(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.LIGHT_GRAY);
        cell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("ID do Usuário", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("CPF", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("RG", font));
        table.addCell(cell);
    }

    private void escreverDadosTabela(PdfPTable table, List<Documento> lista) {
        for (Documento doc : lista) {
            table.addCell(String.valueOf(doc.getId_usuario()));
            table.addCell(doc.getCpf());
            table.addCell(doc.getRg());
        }
    }
}
