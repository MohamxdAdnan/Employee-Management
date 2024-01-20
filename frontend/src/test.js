const [user, setUser] = useState({
    from_date: "",
    to_date: "",
   
  });

  const { from_date,to_date} = user;

  const onInputChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
  };
  