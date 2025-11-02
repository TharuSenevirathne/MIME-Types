package org.example;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/mime")
@MultipartConfig
public class MIME_TYPES extends HttpServlet {

//read text / plain data from http request body

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            //req = data fetch krnw
            //resp = data send krnw

//        String body = new BufferedReader(new InputStreamReader(req.getInputStream())).lines().collect(Collectors.joining("\n"));
//        resp.setContentType("text/plain"); //content type eka blgnn puluwan
//        resp.getWriter().write(body);
//
//        /* resp.setContentType("text/html");//response krnw nan ywnne meka */
//    }


//read x-www-form-urlencoded data from http request body


//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String name = req.getParameter("name");
//        String age = req.getParameter("age");
//
//        resp.setContentType("text/plain");
//        resp.getWriter().write(name+" "+age);
//    }


//read multipart/form data from a http request


//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String name = req.getParameter("name");
//        Part part = req.getPart("file");
//        String fileName = part.getSubmittedFileName();
//
//        resp.setContentType("text/plain");
//        resp.getWriter().write(name+" - "+fileName);
//
//        //@MultipartConfig = file uploading request ekak ywwata passe ekt multipart config ekak dila nathi
//        // nisa servlet ekt handle krnn bh eka nawaththanna thamai me annotation eka denne @Webservlet eka
//        // yatata.
//    }


//read JSON data from http request body


//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        ObjectMapper mapper = new ObjectMapper();
//        JsonNode jsonNode = mapper.readTree(req.getInputStream());
//
//        String name = jsonNode.get("name").asText();
//        String address = jsonNode.get("address").asText();
//
//        resp.setContentType("text/plain");
//        resp.getWriter().write(name + " " + address);
//    }



//read JSON array from http request

    // 1.POSTMAN eke array eka print krgnn widiha

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        ObjectMapper mapper = new ObjectMapper();
//        ArrayNode arrayNode = (ArrayNode) mapper.readTree(req.getReader());
//        StringBuilder stringBuilder = new StringBuilder();
//
//        for (JsonNode node : arrayNode) {
//            String name = node.get("name").asText();
//            String address = node.get("address").asText();
//            stringBuilder.append(name).append(" - ").append(address).append("\n");
//        }
//
//        resp.setContentType("text/plain");
//        resp.getWriter().write(stringBuilder.toString());


    // 2.terminal eke print wenne array eka

        ObjectMapper mapper = new ObjectMapper();
        List<JsonNode> users = mapper.readValue(req.getReader(), new TypeReference<List<JsonNode>>() {
        });

        for (JsonNode node : users) {
            String name = node.get("name").asText();
            String address = node.get("address").asText();
            resp.getWriter().write("name: " + name + ", address: " + address + "\n");
            System.out.println(name+" "+address);
        }

        resp.setContentType("text/plain");
        resp.getWriter().println("OK");

    }

}