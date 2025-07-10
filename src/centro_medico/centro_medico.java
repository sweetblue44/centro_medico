package centro_medico;

import java.util.Scanner;

public class centro_medico {
    public static void main(String[] args) {
        usuariosbd usuarios = new usuariosbd();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n===== MENÚ DE USUARIOS =====");
            System.out.println("1. Mostrar todos los usuarios");
            System.out.println("2. Buscar por ID");
            System.out.println("3. Buscar por Documento");
            System.out.println("4. Buscar por Nombre");
            System.out.println("5. Insertar nuevo usuario");
            System.out.println("6. Actualizar usuario");
            System.out.println("7. Eliminar usuario");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1:
                    usuarios.mostrarUsuarios();
                    break;
                case 2:
                    System.out.print("ID del usuario: ");
                    int id = sc.nextInt();
                    usuarios.buscarPorId(id);
                    break;
                case 3:
                    System.out.print("Documento del usuario: ");
                    int doc = sc.nextInt();
                    usuarios.buscarPorDocumento(doc);
                    break;
                case 4:
                    System.out.print("Nombre del usuario: ");
                    String nombre = sc.nextLine();
                    usuarios.buscarPorNombre(nombre);
                    break;
                case 5:
                    System.out.print("Documento: ");
                    int documento = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nombre: ");
                    String nombreNuevo = sc.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = sc.nextLine();
                    System.out.print("Correo: ");
                    String correo = sc.nextLine();
                    System.out.print("Dirección: ");
                    String direccion = sc.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = sc.nextLine();
                    usuarios.insertarUsuario(documento, nombreNuevo, apellido, correo, direccion, telefono);
                    break;
                case 6:
                    System.out.print("ID del usuario a actualizar: ");
                    int idAct = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nuevo correo: ");
                    String nuevoCorreo = sc.nextLine();
                    System.out.print("Nueva dirección: ");
                    String nuevaDireccion = sc.nextLine();
                    System.out.print("Nuevo teléfono: ");
                    String nuevoTelefono = sc.nextLine();
                    usuarios.actualizarUsuario(idAct, nuevoCorreo, nuevaDireccion, nuevoTelefono);
                    break;
                case 7:
                    System.out.print("ID del usuario a eliminar: ");
                    int idEliminar = sc.nextInt();
                    usuarios.eliminarUsuario(idEliminar);
                    break;
                case 0:
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);

        sc.close();
    }
}

