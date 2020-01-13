<?php 
class Supermercado
{
	private $id;
	private $name;
	private $latitude;
	private $longitude;

	public function getID()
	{
		return $this->id;
	}

	public function setID($value)
	{
		$this->id = $value;
	}

	public function getName()
	{
		return $this->name;
	}

	public function setName($value)
	{
		$this->name = $value;
	}

	public function getLatitude()
	{
		return $this->latitude;
	}

	public function setLatitude($value)
	{
		$this->latitude = $value;
	}

	public function getLongitude()
	{
		return $this->longitude;
	}

	public function setLongitude($value)
	{
		$this->longitude = $value;
	}

	public function list()
	{
		//Criar conexão à base de dados
        $db = new Db_Connect();
        $this->conn = $db->connect();

		//Prepara a query à base de dados
		$sql = "SELECT * FROM Paginas";
		$query = $conexao->query($sql);

		//Retorna o resultado da query
		return $query->fetchAll(PDO::FETCH_ASSOC);
	}

	public function getByID($id)
	{
		//Criar conexão à base de dados
        $db = new Db_Connect();
        $this->conn = $db->connect();

		//Prepara a query à base de dados
		$sql = "SELECT * FROM supermercados WHERE id = " . $id;
		$query = $conexao->query($sql);

		//Retorna o resultado da query
		return $query->fetch(PDO::FETCH_ASSOC);
	}

	public function update()
	{
		//Criar conexão à base de dados
	 $db = new Db_Connect();
        $this->conn = $db->connect();

         $id = $this->id;
         $name= $this->name;
         $latitude=$this->latitude;
         $longitude=$this->longitude;
    


		//Prepara a query à base de dados
		$sql = "Update supermercados SET name = '$name', latitude = '$latitude', longitude = $longitude WHERE id = " . $id;
		return $this->exec($sql);
	}

	public function insert(){
        $db = new Db_Connect();
        $this->conn = $db->connect();

        $name= $this->name;
        $latitude=$this->latitude;
        $longitude=$this->longitude;

		$sql ="INSERT INTO supermercados(name, latitude, longitude) VALUES ('$name', '$latitude', '$longitude')";

		return $conn->exec($sql);
	}

	public function delete(){
        $db = new Db_Connect();
        $this->conn = $db->connect();

        $name= $this->name;
        $latitude=$this->latitude;
        $longitude=$this->longitude;

		$sql ="DELETE supermercados(name, latitude, longitude) VALUES ('$name', '$latitude', '$longitude')";

		return $conexao->exec($sql);
	}
}
?>