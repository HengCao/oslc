package papyrusProvider.resourceaccess;

import java.io.IOException;
import java.util.Iterator;
import java.util.UUID;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.internal.impl.ClassImpl;
import org.eclipse.uml2.uml.internal.impl.PrimitiveTypeImpl;
import org.eclipse.uml2.uml.internal.impl.PropertyImpl;
import org.eclipse.uml2.uml.internal.impl.StructuralFeatureImpl;
import org.eclipse.uml2.uml.resource.UMLResource;

import PapyrusCommon.PapyrusCommon.resources.Attribut;
import PapyrusCommon.PapyrusCommon.resources.Diagramm;
import PapyrusCommon.PapyrusCommon.resources.Modell;
import PapyrusCommon.PapyrusCommon.resources.*;

public class ResourceAccess {
	
	private ResourceSet modelSet = new ResourceSetImpl();
	
	public ResourceAccess(){
		
	}
	

	public static String getFragmentfromType(org.eclipse.uml2.uml.Element e) {

		if (((PropertyImpl) e).getType() instanceof StructuralFeatureImpl) {
			StructuralFeatureImpl s = (StructuralFeatureImpl) ((PropertyImpl) e)
					.getType();
			return s.eProxyURI().fragment();
		} else if (((PropertyImpl) e).getType() instanceof ClassImpl) {
			ClassImpl s = (ClassImpl) ((PropertyImpl) e).getType();
			return s.eProxyURI().fragment();
		} else {
			PrimitiveTypeImpl s = (PrimitiveTypeImpl) ((PropertyImpl) e)
					.getType();
			return s.eProxyURI().fragment();
		}

	}

	public  PapyrusCommon.PapyrusCommon.resources.Resource getResource() {
		PapyrusCommon.PapyrusCommon.resources.Resource resource = new PapyrusCommon.PapyrusCommon.resources.Resource();
		Modell modell = new Modell();
		UUID uuid =UUID.randomUUID();
		int zaehler=0;
		Diagramm diagramm = new Diagramm();

		URI modelUri = URI
				.createURI("file:///E:/HAW/workspace/OSLC_PapyrusProject/model.uml");
	

		modelSet.getPackageRegistry().put(UMLPackage.eNS_URI,
				UMLPackage.eINSTANCE);
		modelSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put(UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE);
		modelSet.createResource(modelUri);
		 Resource modelResource = modelSet.getResource(modelUri, true);

		EcoreUtil.resolveAll(modelSet);

		Model model = (Model) EcoreUtil.getObjectByType(
				modelResource.getContents(), UMLPackage.Literals.MODEL);
		modell.setName(model.getQualifiedName());

		System.err.println("Loaded model: " + model.getQualifiedName() + "\n");
		for (Profile appliedProfile : model.getAppliedProfiles()) {
			System.err.println("Applied profile: " + appliedProfile.getName());
		}
		resource.setIdentifier(model.getQualifiedName()+uuid);
		resource.setTitle( model.getQualifiedName());

		/*
		 * Iterate over all contents of the passed element and collect
		 * recursively.
		 */

	 

		System.err.println("\nCotained elements: \n");

		Iterator<EObject> i = model.eAllContents(); // only elements that are in
													// the name-space of this
													// element
		while (i.hasNext()) {
			
			EObject object = i.next();
			if (object instanceof Class) {
				 diagramm = new Diagramm();
				NamedElement element = (NamedElement) object;
				diagramm.setName(element.getName());

				System.err.println(element.getName());
				System.err.println("- " + element.getQualifiedName());

				for ( Element e : element
						.getOwnedElements()) {
					Attribut attribut = new Attribut();
					attribut.setName(((PropertyImpl) e).getName());
					attribut.setType(getFragmentfromType(e));
					diagramm.addAttribut(attribut);
					zaehler++;
					System.err.println(zaehler+"++" + ((PropertyImpl) e).getName()
							+ " Type : " + getFragmentfromType(e));
				}
				 
				modell.addDiagramm(diagramm);
			}
			
		 
		}
		
		resource.addModell(modell);
		return resource;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Load the model
		URI modelUri = URI
				.createURI("file:///E:/HAW/workspace/OSLC_PapyrusProject/model.uml");
		ResourceSet modelSet = new ResourceSetImpl();

		modelSet.getPackageRegistry().put(UMLPackage.eNS_URI,
				UMLPackage.eINSTANCE);
		modelSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put(UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE);
		modelSet.createResource(modelUri);
		Resource modelResource = modelSet.getResource(modelUri, true);

		 

		Model model = (Model) EcoreUtil.getObjectByType(
				modelResource.getContents(), UMLPackage.Literals.MODEL);

		System.err.println("Loaded model: " + model.getQualifiedName() + "\n");
		for (Profile appliedProfile : model.getAppliedProfiles()) {
			System.err.println("Applied profile: " + appliedProfile.getName());
		}

		/*
		 * Iterate over all contents of the passed element and collect
		 * recursively.
		 */

	//	final String reqStereotypeQualifiedName = "SysML::Requirements::Requirement";

		System.err.println("\nCotained elements: \n");

		Iterator<EObject> i = model.eAllContents(); // only elements that are in
													// the name-space of this
													// element
		while (i.hasNext()) {

			EObject object = i.next();
			if (object instanceof Class) {

				NamedElement element = (NamedElement) object;

				System.err.println(element.getName());
				System.err.println("- " + element.getQualifiedName());

				for (org.eclipse.uml2.uml.Element e : element
						.getOwnedElements()) {

					System.err.println("++" + ((PropertyImpl) e).getName()
							+ " Type : " + getFragmentfromType(e));
				}
				// System.err.println(element.getAppliedStereotype(reqStereotypeQualifiedName));

//				EList<Stereotype> listOfStereotypes = element
//						.getAppliedStereotypes();
//
//				for (Stereotype stereotype : listOfStereotypes) {
//					System.err.println("Stereotype qualified name:"
//							+ stereotype.getQualifiedName());
//					for (Property p : stereotype.getAttributes()) {
//						System.err.println("Stereotype Allattributes "
//								+ p.getName() + " " + getFragmentfromType(p));
//					}
//					// in den stereotype schreiben
//					// element.setValue(stereotype, "text",
//					// "This is the updated text");
//				}
//
//				if (element.getAppliedStereotype(reqStereotypeQualifiedName) != null) { // if
//																						// the
//																						// stereotype
//																						// is
//																						// applied
//					// ...
//				}

				// example for updating elements
				// element.setName(element.getName() + "_updated");
			}
		}
		//System.out.println(getResource().getIdentifier());

		// save the model
		try {
			modelResource.save(null);
		} catch (IOException ioe) {
			// TODO
		}
	}

}
