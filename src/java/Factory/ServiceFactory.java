/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import Entidades.Categoria;

/**
 *
 * @author Rosemberg
 */
public class ServiceFactory {
    
            
    public static IServiceAdapter getDBAdapter(int idCategoria) {
        switch (idCategoria) {
            case 1:
                return new MusicaServices();
            case 2:
                return new ComidaServices();
            default:
                throw new IllegalArgumentException("No soportado");
        }
    }
}
