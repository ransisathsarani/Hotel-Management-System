<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha/js/bootstrap.min.js"></script>
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 
  
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Kanneliya Forest Resort</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="index.jsp">Home</a></li>
      <li><a href="#">Inventory</a></li>
      <li><a href=ReservationControllerServlet>Accomodation</a></li>
      <li><a href="#">Staff</a></li>
      <li class="active">Events</li>
      <li><a href="#">Restaurant</a></li>
      <li><a href="#">Client Finance</a></li>
      <li><a href="#">Resort Finance</a></li>
    </ul>
  </div>
</nav>

<div class="container" style="margin-bottom: 20px;">
<ul class="nav nav-tabs">
    <li><a href="checkAvailability.jsp">Add Event</a></li>
    <li ><a href="list-enquiriess.jsp">Enquiries</a></li>
    <li class="active"><a href="#">Events</a></li>
  </ul>
  </div>
  
  <div class="container">
  <h2>Event Menu</h2>
  <form action="EventControllerServlet" method="GET">
 <input type="hidden" name="command" value="UPDATE_MENU" />
			
			<input type="hidden" name="eventId" value="${THE_EVENT.id}" />
			
	<div class="form-group">
      <label for="appetizer">Appetizer</label>
      <select class="form-control" id="appetizer" name="appetizer" value="${THE_EVENT.appetizer}" required>
      <option value="maalu_pan">Maalu Pan</option>
      <option value="dhal_vadai">Dhal Vadai</option>
      <option value="fish_cutlet">Fish Cutlets</option>
      <option value="egg_roll">Egg Rolls</option>
      </select>
    </div>			
  
    <div class="form-group">
      <label for="soup">Soup</label>
      <select class="form-control"  id = "soup" name="soup" value="${THE_EVENT.soup}" required >
      <option value="chicken_shorba">Chicken Shorba</option>
      <option value="thai_chicken_and_noodle_soup">Thai Chicken and Noodle Soup</option>
      <option value="vegetable_cream_soup">Vegetable Cream Soup</option>
      <option value="crab_bisque">Crab Bisque</option>
      </select>
    </div>

    <div class="form-group">
      <label for="rice1">Rice - Selection 1:</label>
      <select class="form-control"  id = "rice1" name="rice1" value="${THE_EVENT.rice1}" required >
      <option value="steamed_basmati_rice">Steamed Basmati Rice</option>
      <option value="yellow_rice">Yellow Rice</option>
      <option value="vegetable_fried_rice">Vegetable Fried Rice</option>
      <option value="vegetable_biriyani">Vegetable Biriyani</option>
      <option value="red_rice">Red Rice</option>
      
      </select>
    </div>
 
    <div class="form-group">
      <label for="rice2">Rice - Selection 2:</label>
	<select class="form-control"  id = "rice2" name="rice2" value="${THE_EVENT.rice2}" required >
      <option value="steamed_basmati_rice">Steamed Basmati Rice</option>
      <option value="yellow_rice">Yellow Rice</option>
      <option value="vegetable_fried_rice">Vegetable Fried Rice</option>
      <option value="vegetable_biriyani">Vegetable Biriyani</option>
      <option value="red_rice">Red Rice</option>
      
      </select> 
    </div>
    
        <div class="form-group">
      <label for="noodles ">Noodles:</label>
      <select class="form-control" id = "noodles" name="noodles" value="${THE_EVENT.noodles}" required >
      <option value="chinese_noodles">Chinese Noodles</option>
      <option value="buttered_noodles">Buttered Noodles</option>
      <option value="seafood_noodles">Seafood Noodles</option>
      <option value="cheese_pasta">Cheese Pasta</option>
      
      </select> 
    </div>
    
    <div class="form-group">
      <label for="fish ">Fish:</label>
      <select class="form-control" id = "fish" name="fish" value="${THE_EVENT.fish}" required >
      <option value="fish_ambul_thiyal">Fish Ambul Thiyal</option>
      <option value="chilli_fish">Chilli Fish</option>
      <option value="fried_salaya">Fried Salaya</option>
      <option value="fish_stew">Fish Stew</option>
      <option value="devilled_fish">Devilled Fish</option>
      
      </select> 
    </div>
    
    <div class="form-group">
      <label for="chicken ">Chicken:</label>
      <select class="form-control" id = "chicken" name="chicken" value="${THE_EVENT.chicken}" required >
      <option value="tandoori_chicken">Tandoori Chicken</option>
      <option value="butter_chicken">Butter Chicken</option>
      <option value="devilled_chicken">Devilled Chicken</option>
      <option value="chilli_chicken_curry">Chilli Chicken Curry</option>
      <option value="chicken_chutney">Chicken Chutney</option>
      
      </select> 
    </div>
    
     <div class="form-group">
      <label for="vegetable1 ">Vegetable - Selection 1:</label>
      <select class="form-control" id = "vegetable1" name="vegetable1" value="${THE_EVENT.vegetable1}" required >
      <option value="dhal_curry">Dhal Curry</option>
      <option value="brinjal_moju">Brinjal Moju</option>
      <option value="mango_curry">Mango  Curry</option>
      <option value="kadju_curry">Kadju Curry</option>
      <option value="tempered_mushroom">Tempered Mushroom</option>
      <option value="potato_curry">Potato Curry</option>
      
      
      </select> 
    </div>
    
     <div class="form-group">
      <label for="vegetable2 ">Vegetable - Selection 2:</label>
      <select class="form-control" id = "vegetable2" name="vegetable2" value="${THE_EVENT.vegetable2}" required >
      <option value="dhal_curry">Dhal Curry</option>
      <option value="brinjal_moju">Brinjal Moju</option>
      <option value="mango_curry">Mango  Curry</option>
      <option value="kadju_curry">Kadju Curry</option>
      <option value="tempered_mushroom">Tempered Mushroom</option>
      <option value="potato_curry">Potato Curry</option>
      
      
      </select>     </div>
    
     <div class="form-group">
      <label for="vegetable3 ">Vegetable - Selection 3:</label>
      <select class="form-control" id = "vegetable3" name="vegetable3" value="${THE_EVENT.vegetable3}" required >
      <option value="dhal_curry">Dhal Curry</option>
      <option value="brinjal_moju">Brinjal Moju</option>
      <option value="mango_curry">Mango  Curry</option>
      <option value="kadju_curry">Kadju Curry</option>
      <option value="tempered_mushroom">Tempered Mushroom</option>
      <option value="potato_curry">Potato Curry</option>
      
      
      </select> 
      
     </div>
    
    <div class="form-group">
      <label for="dessert1 ">Dessert - Selection 1:</label>
      <select class="form-control" id = "dessert1" name="dessert1" value="${THE_EVENT.dessert1}" required >
      <option value="fruit_salad">Fruit Salad</option>
      <option value="watalappan">Watalappan</option>
      <option value="curd_with_treacle">Curd with Treacle</option>
      <option value="vanilla_icecream">Ice Cream Vanilla</option>
      <option value="chocolate_icecream">Ice Cream Chocolate</option>
      <option value="fruits">Fruits</option>
      
      
      </select> 
    </div>
    
    <div class="form-group">
      <label for="dessert2 ">Dessert - Selection 2:</label>
	  <select class="form-control" id = "dessert2" name="dessert2" value="${THE_EVENT.dessert2}" required >
      <option value="watalappan">Watalappan</option>
      <option value="fruit_salad">Fruit Salad</option>
      <option value="curd_with_treacle">Curd with Treacle</option>
      <option value="vanilla_icecream">Ice Cream Vanilla</option>
      <option value="chocolate_icecream">Ice Cream Chocolate</option>
      <option value="fruits">Fruits</option>
      
      
      </select> 
          </div>
    
       

    <button type="submit" value="Save" class="btn btn-default save">Submit</button>
  </form>
</div>
  
  

</body>
</html>