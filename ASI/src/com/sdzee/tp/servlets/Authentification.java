package com.sdzee.tp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdzee.tp.beans.Utilisateur;

public class Authentification extends HttpServlet {

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /*
         * R�cup�ration des donn�es saisies, envoy�es en tant que param�tres de
         * la requ�te GET g�n�r�e � la validation du formulaire d'authentification
         */
    	String id = request.getParameter( "identifiant" );
        String motDePasse = request.getParameter( "pwd" );
      
        String message;
       
        Utilisateur utilisateur=new Utilisateur();
     
        utilisateur.setNom("bruno");
        utilisateur.setPrenom("vincent");
     
        utilisateur.setEmail("bruno.vincent@gmail.com");
  
     
        /*
         * V�rification existance de l'utilisateur dans l'annuaire + remplissage du message
         * 
         * 
         */
        Boolean test=true;
        
        /*
         * Initialisation du message � afficher : si un des champs obligatoires
         * du formulaire d'authentification n'est pas renseign�, alors on affiche un message
         * d'erreur
         */
        if ( id.trim().isEmpty() || motDePasse.trim().isEmpty() ) {
            message = "Vous n'avez pas rempli tous les champs obligatoires. ";
            test=false;
        } else {
            message = "";
        }
        
        
       

        /* Transmission � la page JSP en charge de l'affichage des donn�es */
        if(!test){
        	message = "authentification �chou�e";
        	/* Ajout du message � l'objet requ�te */
            request.setAttribute( "message", message );
        	this.getServletContext().getRequestDispatcher( "/authentification.jsp" ).forward( request, response );
        }
        else{
        	message = "authentification r�ussite";
        	request.setAttribute( "message", message );
        	request.setAttribute( "utilisateur", utilisateur );
        	this.getServletContext().getRequestDispatcher( "/informationUser.jsp" ).forward( request, response );
        }
        
    }
}


