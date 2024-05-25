<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Billing Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="source.js"></script>
    
    <style>
      table,
      th,
      td {
          border: 1px solid black;
          border-collapse: collapse;
      }

      th{
        text-align: left;
      }
      td {
        padding: 30px;
      }
      </style>
</head>
<body>
    <header>
        <img src="https://www.mcu.ac.in/wp-content/uploads/2024/02/MCU_Header_Final.jpg" alt="MCU Bhopal" width="100%"
          height="220px" style="border:5px solid black">
    
    </header>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
          <a class="navbar-brand" href="#">Exam Valuation Billing Form</a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="operation.html">Home</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="https://www.mcu.ac.in/">Site</a>
              </li>
             </ul>
  
            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success" type="submit">Search</button>
  
          </div>
        </div>
      </nav>

      <form style="border: 3px solid black; height: auto; width: auto; background-color: aqua; font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;">
        <div class = "container" style = "text-align:center; border:2px solid black; padding:2px">
          <label>Months and Year of Examination:</label>
          <input type = "date" name="timestamp" id="timestamp" required />
          <br><br>
          <label>Name Of Claimant:</label>
          <input type = "text" name="fname" id="fname" required/>
          <br><br>

          <label>Collage Name:</label>
          <input type = "text" name="cllg_name" id="cllg_name" required/>
          <br><br>

          <label>Full Postal Address:</label>
          <input type = "text" name="address" id="address" required/>
          <br><br>

          <label>Contact No:</label>
          <input type = "number" name="contact_no" id="contact_no"  required/>
          <br><br>

          <label>Code of Claimant:</label>
          <input type = "text" name="unique_id" id="unique_id" required/>
          <br><br>
        </div>
        

        
      </form>
      <form style="border: 3px solid black; height: auto; width: auto; background-color: rgb(64, 191, 191); font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;">
      
        <table style="border: 1;">
          <thead>
          <tr><td><b>S No</b></td>&nbsp;
          <td><b>Date </b></td>&nbsp;
          <td><b>Name of Class </b></td>&nbsp;
          <td><b> Paper Code </b></td>
          <td><b> Subject </b></td>
          <td><b> Paper Code </b></td>
          <td><b> Total AB Valued </b></td>
          <td><b> Rate</b></td>
          <td><b> Amount(Rs.)</b></td>
          <td><b> Extra</b></td></thead>
        
        
        
        
        </tr></table>&nbsp;

      </form>

    
</body>
</html>
