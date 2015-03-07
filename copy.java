/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tdsi;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;

/**
 *
 * @author ouz
 */
public class Copy {
    static File src;
    static File dst;
    static void copier() throws FileNotFoundException, IOException {
        //creation de Filechooser
        JFileChooser jfc=new JFileChooser();
        //dÃ©finir le titre de la fenetre
        jfc.setDialogTitle("choisir un fichier");
        //on ouvrela fenetre,  val contient 0 s'il clique sur ouvrir
        int val=jfc.showOpenDialog(jfc);
        //s'il ne clique pas sur ourvrir on ferme le projet
        if(val!=JFileChooser.APPROVE_OPTION)
            System.exit(1);
        //on choisi le File qu'il a choisi
        src=jfc.getSelectedFile();
        //on crÃ©e un flux de lecture du fichier source
        FileInputStream fis =new FileInputStream(src);
        //on crÃ©e le fichier de destination dans le projet
        dst=new File("copie_"+jfc.getName(src));
        //on crÃ©e un flux d'ecriture sur dst
        FileOutputStream fos=new FileOutputStream(dst);
        
        //Bufferization des deux flux
        BufferedInputStream bis=new BufferedInputStream(fis);
        BufferedOutputStream bos=new BufferedOutputStream(fos);
        
        //on dÃ©clare le table de byte
        byte [] buff= new byte[1024];
        //la taille des bytes lus
        int len;
        while((len=bis.read(buff))!=-1){
            bos.write(buff,0,len);
        }
        bis.close();
        bos.close();
        
    }
}
