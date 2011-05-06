# Tapestry 5 jQuery integration Module - 2.1.0

## List Of Contributors
- Robin Komiwes as robink
- Andreas Andreou as andyhot
- Christian Riedel as criedel
- François Facon as got5     
- Tom van Dijk as trolando
- Emmanuel DEMEY as Gillespie59
- Clément Uster as cluster

##Hosting
Christophe Furmaniak 	

## Changelog

- 2.1.0 : switch to Tapestry 5.2.5
		  add (Tabs, Accordion, AjaxUpload, Button)	
- 1.1-SNAPSHOT : exclusive jQuery components
- 1.0-SNAPSHOT : initial releases

## Features

This module provides jQuery integration for Tapestry 5 and completely drop out Prototype, Scriptaculous and the base tapestry.js script. 

It also relies on [jQuery](http://jquery.com) 1.5 and [jQuery UI](http://jqueryui.com/) 1.8.

Exclusive jQuery components : 

- **Dialog** with **DialogLink** and **DialogAjaxLink**
	- based on [http://jqueryui.com/demos/dialog/](http://jqueryui.com/demos/dialog/)
- **Tabs** 
	- based on [http://jqueryui.com/demos/tabs/](http://jqueryui.com/demos/tabs/)	
- **Accordion** 
	- based on [http://jqueryui.com/demos/accordion/](http://jqueryui.com/demos/accordion/)	
- **AjaxUpload** 
	- based on [https://github.com/valums/file-uploader](https://github.com/valums/file-uploader)	
- **Slider** 
	- based on [http://jqueryui.com/demos/slider/](http://jqueryui.com/demos/slider/)	
- **RangeSlider** 
	- based on [http://jqueryui.com/demos/slider/#range](http://jqueryui.com/demos/slider/#range)
		
Exclusive jQuery Mixins :

- **Button** 
	- based on [http://jqueryui.com/demos/button/](http://jqueryui.com/demos/button/)	
- **Tooltip** 
	- based on [http://access.aol.com/csun2011/](http://access.aol.com/csun2011/)
- **Mask** 
	- based on [http://digitalbush.com/projects/masked-input-plugin/](http://digitalbush.com/projects/masked-input-plugin/)

Theses components were originally present in Tapestry 5 Core and can still be used as it :

- **Zone**
- **Form Validation** 
	- based on: [http://docs.jquery.com/Plugins/Validation](http://docs.jquery.com/Plugins/Validation)
- **AjaxFormLoop**
- **FormFragment**
- **TriggerFragment**
- **Grid (in place mode)**
- **DateField**
    - based on: [http://jqueryui.com/demos/datepicker/](http://jqueryui.com/demos/datepicker/)

Due to some extensibility issues of Core components, theses are originals components need to be used using the "jquery" namespace

- **Autocomplete**
	- based on: [http://jqueryui.com/demos/autocomplete/](http://jqueryui.com/demos/autocomplete/)
- **Palette**
 

## Maven dependency

To use this plugin, add the following dependency in your `pom.xml`.

	<dependencies>
		...
		<dependency>
			<groupId>org.got5</groupId>
			<artifactId>tapestry5-jquery</artifactId>
			<version>2.1.0</version>
		</dependency>
		...
	</dependencies>
	
	<repositories>
		...
		<repository>
			<id>devlab722-repo</id>
			<url>http://nexus.devlab722.net/nexus/content/repositories/releases
			</url>
			<snapshots>
				<enabled>false</enabled>
			</snapshots>
		</repository>

		<repository>
			<id>devlab722-snapshot-repo</id>
			<url>http://nexus.devlab722.net/nexus/content/repositories/snapshots
			</url>
			<releases>
				<enabled>false</enabled>
			</releases>
		</repository>
		...
	</repositories>
	


## More Informations & contacts

* The [wiki](https://github.com/got5/tapestry5-jquery/wiki)
* Twitter: [http://twitter.com/GOTapestry5](http://twitter.com/GOTapestry5)

## How to use it

Just add tapestry5-jquery to your classpath (see Maven dependency snippet below)!

Then use components like you would normally do. For Autocomplete and Palette use "jquery" namespace:
 
	<t:form>
        <t:jquery.autocomplete />
		<t:submit />
    </t:form>

Or add jquery to the tapestry-library namespace:

	<html xmlns:t="http://tapestry.apache.org/schema/tapestry_5_1_0.xsd"
      xmlns:p="tapestry:parameter"
      xmlns:j="tapestry-library:jquery">

    <t:form>
        <j:palette />
        <t:textfield t:mixins="jquery/autocomplete" ... />
        <t:submit />
    </t:form>

	</html>

## You still need to have PrototypeJS and the components originally included in tapestry ?

Tapestry5-jquery project allows you to choose whether to include or not Prototype (and original tapestry components).
jQuery will be added to the javascript stack in every case.
In your AppModule, contributeApplicationDefaults method, you can add `configuration.add(JQuerySymbolConstants.SUPPRESS_PROTOTYPE, "false");`

## Note about jQuery

In traditional jQuery development, we are used to manipulate the `$` alias to select the elements we want to play with.
jQuery allows us to change this default alias (for compatibility with other js frameworks also using the `$` alias : like PrototypeJS, included in Tapestry, for example).
The tapestry5-jquery project has an option permitting you to customize this alias : in your AppModule, contributeApplicationDefaults method, you can add `configuration.add(JQuerySymbolConstants.JQUERY_ALIAS, "yourOwnAlias");`.
The default jquery alias is `$`.

By the way, if you've set the `JQuerySymbolConstants.SUPPRESS_PROTOTYPE` option to false, you may not use `$` to refer to jQuery, because `$` actually refers to Prototype.
Thus, you may want to change jQuery's alias in that particular case.
However, if you didn't change it, jQuery's alias will automatically be set to `$j`. 


## Important notice

All kind of feedback is very welcome. Please use [Github issues system](http://github.com/got5/tapestry5-jquery/issues) for that.

## License

This project is distributed under Apache 2 License. See LICENSE.txt for more information. 
