const express=require("express"),app=express();
app.use(express.static("frontend/pages"));
app.get("/",(req,res)=>res.sendFile(__dirname+"/frontend/pages/index.html"));
app.listen(8080,()=>console.log("🌐 Aurvo Cloud Portal disponible en http://localhost:8080"));
