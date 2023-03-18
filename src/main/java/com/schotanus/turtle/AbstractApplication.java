package com.schotanus.turtle;

 import java.util.Locale;
 import java.util.ResourceBundle;
 
 import com.schotanus.turtle.model.MessageSeverity;
 import com.schotanus.turtle.model.status.StatusModel;
 
 /**
  * Collection of elements that probably every application wishes to use.
  * Design:<br>
  * This class is a sort of facade class.
  * Most calls to methods in this class are passed through to an object that
  * implements the {@link Applicationable} interface.
  * Using a facade class allows us to use different classes behind the facade
  * (as long as that class implements the interface {@link Applicationable}).
  * @author Kees Schotanus
  * @version 1.1
  */
 public abstract class AbstractApplication {
 
     /**
      * The one and only application object to which all calls are passed.
      * Initially an object of type {@link ApplicationStandard} is used but
      * you can set this member to any object that implements the
      * {@link Applicationable} interface.
      * @see #setApplication(Applicationable)
      */
     private static Applicationable application = new ApplicationStandard();
 
     /**
      * Locale to be used for this application.
      */
     private static Locale locale = Locale.getDefault();
  
     /**
      * Resource bundle containing all localizable properties.
      */
     private static ResourceBundle resourceBundle = ResourceBundle.getBundle("com.schotanus.turtle.Turtle");
 

     /**
      * Sets the application.
      * @param theApplication The application.
      * @pre theApplication != null.
      */
     public static void setApplication(final Applicationable theApplication) {
         application = theApplication;
     }
 
     /**
      * Gets the resource bundle.
      * @return The resource bundle.
      */
     public static ResourceBundle getResourceBundle() {
         return resourceBundle;
     }
 
     /**
      * Sets the resource bundle.
      * @param bundle Resource bundle.
      * @pre resourceBundle != null
      */
     public static void setResourceBundle(final ResourceBundle bundle) {
         resourceBundle = bundle;
     }
 
     /**
      * Gets the locale.
      * @return The locale.
      */
     public static Locale getLocale() {
         return locale;
     }
 
     /**
      * Sets the locale.
      * @param theLocale The locale.
      */
     public static void setLocale(final Locale theLocale) {
         locale = theLocale;
     }
 
     /**
      * Gets the status model from the contained {@link #application}.
      * @return Status model of the contained {@link #application}.
      */
     public static StatusModel getStatusModel() {
         return application.getStatusModel();
     }
 
     /**
      * Changes the status model and notifies the listeners of this event.
      * @param message The new message for the status model.
      * The severity is assumed to be of type NORMAL.
      * @see #changeStatusModel(String, MessageSeverity)
      */
     public static void changeStatusModel(final String message) {
         changeStatusModel(message, MessageSeverity.NORMAL);
     }
 
     /**
      * Changes the status model and notifies the listeners of this event.
      * @param message The new message for the status model.
      * @param severity Severity code of the message.
      */
     public static void changeStatusModel(
             final String message, final MessageSeverity severity) {
         application.changeStatusModel(message, severity);
     }
 
     /**
      * Terminates the application.
      * Use this method after a fatal error occurs from which you can't
      * recover.
      * @param reason Reason why the application is terminated.
      * @post Application terminated with error code 1.
      */
     public static void terminate(final String reason) {
         System.out.println(reason);
         System.exit(1);
     }
 
 
 }