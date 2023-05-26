package JPA;

import JPA.exceptions.NonexistentEntityException;
import JPA.exceptions.PreexistingEntityException;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;



/**
 * Esta clase proporciona métodos para interactuar con la entidad TarjetaCreditoJPA en la base de datos.
 * Los métodos permiten crear, editar, eliminar y buscar tarjetas de crédito, así como obtener el número total de tarjetas de crédito.
 * La clase utiliza un EntityManagerFactory para obtener un EntityManager y gestionar las transacciones de la base de datos.
 * Usa el patrón de acceso a datos Object-Relational Mapping (ORM) proporcionado por JPA.
 * Posibles excepciones que pueden lanzarse: NonexistentEntityException, PreexistingEntityException, Exception.
 * @author josemaria
 */
public class TarjetaCreditoDAO implements Serializable {

    /**
     * Crea un nuevo objeto TarjetaCreditoDAO con el EntityManagerFactory especificado.
     * @param emf el EntityManagerFactory que se utilizará para obtener el EntityManager
     */
    public TarjetaCreditoDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private final EntityManagerFactory emf;


    /**
     * Devuelve un EntityManager para interactuar con la base de datos.
     *  @return el EntityManager
     */
    public EntityManager getEntityManager() {
        return emf.createEntityManager(); // Crea un nuevo EntityManager
    }

    /**
     * Crea una nueva tarjeta de crédito en la base de datos.
     * Si la tarjeta de crédito ya existe, se lanza una PreexistingEntityException.
     * @param tarjetaCreditoJPA la tarjeta de crédito a crear
     * @throws PreexistingEntityException si la tarjeta de crédito ya existe
     */
    public void create(TarjetaCreditoJPA tarjetaCreditoJPA) throws PreexistingEntityException{
        EntityManager em = null;
        try { // Intenta crear la tarjeta de crédito
            em = getEntityManager(); // Obtiene un EntityManager
            em.getTransaction().begin(); // Inicia una transacción
            em.persist(tarjetaCreditoJPA); // Crea la tarjeta de crédito
            em.getTransaction().commit(); // Confirma la transacción
        } catch (Exception ex) { // Si no se ha podido crear la tarjeta de crédito
            if (findTarjetaCreditoJPA(tarjetaCreditoJPA.getNumeroTarjeta()) != null) { // Si la tarjeta de crédito ya existe
                throw new PreexistingEntityException("TarjetaCreditoJPA " + tarjetaCreditoJPA + " already exists.", ex);
            }
        } finally { // Si se ha podido crear la tarjeta de crédito cerramos el EntityManager
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * Edita una tarjeta de crédito existente en la base de datos.
     * Si la tarjeta de crédito no existe, se lanza una NonexistentEntityException.
     * @param tarjetaCreditoJPA la tarjeta de crédito a editar
     * @throws NonexistentEntityException si la tarjeta de crédito no existe
     */
    public void edit(TarjetaCreditoJPA tarjetaCreditoJPA) throws NonexistentEntityException{
        EntityManager em = null; // Obtiene un EntityManager
        try { // Intenta editar la tarjeta de crédito
            em = getEntityManager(); // Obtiene un EntityManager
            em.getTransaction().begin(); // Inicia una transacción
            em.merge(tarjetaCreditoJPA); // Edita la tarjeta de crédito
            em.getTransaction().commit();  // Confirma la transacción
        } catch (Exception ex) { // Si no se ha podido editar la tarjeta de crédito
            String msg = ex.getLocalizedMessage(); // Obtiene el mensaje de error
            if (msg == null || msg.length() == 0) { // Si el mensaje de error está vacío
                String id = tarjetaCreditoJPA.getNumeroTarjeta(); // Obtiene el número de la tarjeta de crédito
                if (findTarjetaCreditoJPA(id) == null) { // Si la tarjeta de crédito no existe
                    throw new NonexistentEntityException("The tarjetaCreditoJPA with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) { // Si se ha podido editar la tarjeta de crédito cerramos el EntityManager
                em.close();
            }
        }
    }

/**
     * Elimina una tarjeta de crédito existente en la base de datos.
     * Si la tarjeta de crédito no existe, se lanza una NonexistentEntityException.
     * @param id el número de la tarjeta de crédito a eliminar
     * @throws NonexistentEntityException si la tarjeta de crédito no existe
     */
    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null; // Obtiene un EntityManager
        try { // Intenta eliminar la tarjeta de crédito
            em = getEntityManager(); // Obtiene un EntityManager
            em.getTransaction().begin(); // Inicia una transacción
            TarjetaCreditoJPA tarjetaCreditoJPA;// Crea una tarjeta de crédito
            try { // Intenta obtener la tarjeta de crédito
                tarjetaCreditoJPA = em.getReference(TarjetaCreditoJPA.class, id); // Obtiene la tarjeta de crédito
            } catch (EntityNotFoundException ex) { // Si la tarjeta de crédito no existe
                throw new NonexistentEntityException("The tarjetaCreditoJPA with id " + id + " no longer exists.", ex);
            }
            em.remove(tarjetaCreditoJPA); // Elimina la tarjeta de crédito
            em.getTransaction().commit(); // Confirma la transacción
        } finally { // Si se ha podido eliminar la tarjeta de crédito cerramos el EntityManager
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * Obtiene una lista de todas las tarjetas de crédito existentes en la base de datos
     * @return la lista de tarjetas de crédito
     */
    public List<TarjetaCreditoJPA> findTarjetaCreditoJPAEntities() {
        return findTarjetaCreditoJPAEntities(true, -1, -1);
    }

    /**
     * Obtiene una lista de tarjetas de crédito existentes en la base de datos.
     * Puede especificarse el número máximo de tarjetas de crédito a obtener y el primer resultado a obtener.
     * @param maxResults el número máximo de tarjetas de crédito a obtener
     * @param firstResult el primer resultado a obtener
     * @return la lista de tarjetas de crédito
     */
    public List<TarjetaCreditoJPA> findTarjetaCreditoJPAEntities(int maxResults, int firstResult) {
        return findTarjetaCreditoJPAEntities(false, maxResults, firstResult);
    }

    /**
     * Obtiene una lista de tarjetas de crédito existentes en la base de datos.
     * Puede especificarse si se desea obtener todas las tarjetas de crédito o un número máximo de tarjetas de crédito y el primer resultado a obtener.
     * @param all true si se desean obtener todas las tarjetas de crédito, false si se desea obtener un número máximo de tarjetas de crédito
     * @param maxResults el número máximo de tarjetas de crédito a obtener
     * @param firstResult el primer resultado a obtener
     * @return la lista de tarjetas de crédito
     */
    private List<TarjetaCreditoJPA> findTarjetaCreditoJPAEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager(); // Obtiene un EntityManager
        try {
            CriteriaQuery<TarjetaCreditoJPA> cq = em.getCriteriaBuilder().createQuery(TarjetaCreditoJPA.class); // Crea un CriteriaQuery para la clase TarjetaCreditoJPA
            cq.select(cq.from(TarjetaCreditoJPA.class)); // Selecciona todas las tarjetas de crédito de la base de datos
            TypedQuery<TarjetaCreditoJPA> q = em.createQuery(cq); // Utilizamos TypedQuery con el tipo seguro
            if (!all) { // Si no se desean obtener todas las tarjetas de crédito
                q.setMaxResults(maxResults); // Se especifica el número máximo de tarjetas de crédito a obtener
                q.setFirstResult(firstResult); // Se especifica el primer resultado a obtener
            }
            List<TarjetaCreditoJPA> lista = q.getResultList(); // Obtiene la lista de tarjetas de crédito
            lista.forEach(TarjetaCreditoJPA::actualizarGastado); // Actualiza el campo "gastado" de cada tarjeta de crédito
            return lista; // Devuelve la lista de tarjetas de crédito
        } finally { // Si se ha podido obtener la lista de tarjetas de crédito cerramos el EntityManager
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * Busca una tarjeta de crédito por su ID en la base de datos.
     * Si se encuentra la tarjeta de crédito, se actualiza el campo "gastado".
     * @param id el ID de la tarjeta de crédito a buscar
     * @return la tarjeta de crédito encontrada, o null si no se encuentra
     */
    public TarjetaCreditoJPA findTarjetaCreditoJPA(String id) {
        EntityManager em = getEntityManager(); // Obtiene un EntityManager
        try { // Intenta obtener la tarjeta de crédito
            TarjetaCreditoJPA tarjeta = em.find(TarjetaCreditoJPA.class, id); // Obtiene la tarjeta de crédito
            tarjeta.actualizarGastado(); // Actualiza el campo "gastado" de la tarjeta de crédito
            return tarjeta;  // Devuelve la tarjeta de crédito
        } finally {
            em.close(); // Cierra el EntityManager
        }
    }

    /**
     * Obtiene el número total de tarjetas de crédito en la base de datos.
     * @return el número total de tarjetas de crédito
     */
    public int getTarjetaCreditoJPACount() {
        EntityManager em = getEntityManager(); // Obtiene un EntityManager
        try { // Intenta obtener el número total de tarjetas de crédito
            CriteriaBuilder cb = em.getCriteriaBuilder(); // Crea un CriteriaBuilder
            CriteriaQuery<Long> cq = cb.createQuery(Long.class); // Crea un CriteriaQuery para Long
            Root<TarjetaCreditoJPA> rt = cq.from(TarjetaCreditoJPA.class); // Crea un Root para TarjetaCreditoJPA
            cq.select(cb.count(rt)); // Selecciona el número total de tarjetas de crédito
            TypedQuery<Long> q = em.createQuery(cq); // Utilizamos TypedQuery con el tipo seguro
            return q.getSingleResult().intValue(); // Devuelve el número total de tarjetas de crédito
        } finally { // Si se ha podido obtener el número total de tarjetas de crédito cerramos el EntityManager
            if (em != null) {
                em.close();
            }
        }
    }
    
}
