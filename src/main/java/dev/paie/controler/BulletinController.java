package dev.paie.controler;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dev.paie.BulletinJason;
import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Cotisation;
import dev.paie.repository.BulletinSalaireRepository;



@RestController
public class BulletinController {
	public static final Logger LOG = LoggerFactory.getLogger(BulletinController.class);

	// @Autowired
	private BulletinSalaireRepository bulletinSalRepository;

	public BulletinController(BulletinSalaireRepository bulletinSalRepository) {
		super();
		this.bulletinSalRepository = bulletinSalRepository;
	}

	@RequestMapping(value = "/bulletins", method = RequestMethod.GET)
	@ResponseBody
	public List<BulletinJason> findBulletin() {
		BigDecimal salaireBase							= new BigDecimal("0.0") ;
		BigDecimal nbrHeureBase 						= new BigDecimal("0.0") ;
		BigDecimal tauxBase								= new BigDecimal("0.0") ;
		BigDecimal salaireBrut							= new BigDecimal("0.0") ;		
		BigDecimal primeExceptionnelle 					= new BigDecimal("0.0") ;	
		BigDecimal totalRetenuSalarialNonImposable		= new BigDecimal("0.0") ;	
		BigDecimal salaireNetImposable					= new BigDecimal("0.0") ;	
		BigDecimal salaireNetAPayer						= new BigDecimal("0.0") ;		
		BigDecimal totalRetenuSalarialImposable 		= new BigDecimal("0.0") ;	
		
		List<BulletinJason>  lstBullJason = new ArrayList<BulletinJason>();
		
		LOG.info( "Liste des bulletins de salaire : ");
		for( BulletinSalaire bullSalaire : bulletinSalRepository.findAll()) {
			LOG.info( " - identifiant    : " + bullSalaire.getId());
			LOG.info( " - date de début  : " + bullSalaire.getPeriode().getDateDebut());
			LOG.info( " - date de fin    : " + bullSalaire.getPeriode().getDateFin());
			LOG.info( " - matricule      : " + bullSalaire.getRemunerationEmploye().getMatricule());
			
			nbrHeureBase 			= bullSalaire.getRemunerationEmploye().getGrade().getNbHeuresBase() ;
			tauxBase 				= bullSalaire.getRemunerationEmploye().getGrade().getTauxBase();
			salaireBase     		= nbrHeureBase.multiply( tauxBase)   ; 
			salaireBase				= salaireBase.add( primeExceptionnelle);
			LOG.info( " - salaire de base  : " + salaireBase.toString()) ; 
			
			salaireBrut     = salaireBase.add( bullSalaire.getPrimeExceptionnelle());
			LOG.info( " - salaire brut  : " + salaireBrut.toString()) ; 
			
			List<Cotisation>	lstCotisations = bullSalaire.getRemunerationEmploye().getProfilRemuneration().getCotisations();
			BigDecimal          retenu ;
			for( Cotisation cotisation : lstCotisations ) {
				if( cotisation.getImposable()) {
					retenu  = cotisation.getTauxSalarial().multiply( salaireBrut) ;
					totalRetenuSalarialImposable =
							totalRetenuSalarialImposable.add( retenu) ;
				}else {
					retenu = cotisation.getTauxSalarial().multiply( salaireBrut) ;
					totalRetenuSalarialNonImposable = 
							totalRetenuSalarialNonImposable.add( retenu) ;
				}
				LOG.info( " cotisation.getTauxSalarial() : " + cotisation.getTauxSalarial());
				LOG.info( " totalRetenuSalarialImposable  : " + totalRetenuSalarialImposable) ; 
				LOG.info( " totalRetenuSalarialNonImposable  : " + totalRetenuSalarialNonImposable) ; 
				
			}
			
			salaireNetImposable = new BigDecimal( salaireBrut.toString()) ;
			salaireNetImposable = salaireNetImposable.subtract( totalRetenuSalarialNonImposable) ;
			LOG.info( " - sal net impo.  : " + salaireNetImposable.toString()) ; 
		
			salaireNetAPayer	= new BigDecimal( salaireNetImposable.toString()) ;
			salaireNetAPayer 	= salaireNetAPayer.subtract( totalRetenuSalarialImposable);
			LOG.info( " - sal net à payer  : " + salaireNetAPayer.toString()) ; 
			
			BulletinJason bullJason = 
					new BulletinJason(  
							bullSalaire.getId(), 
							LocalDateTime.now(), 
							bullSalaire.getPeriode().getDateDebut(),
							bullSalaire.getPeriode().getDateFin(), 
							bullSalaire.getRemunerationEmploye().getMatricule(), 
							salaireBrut,
							salaireNetImposable,
							salaireNetAPayer) ;
			
				
			lstBullJason.add( bullJason );
			
		}
		
		return lstBullJason; 
	}


}
