import { useEffect, useState } from "react";

export default function Gallery() {
  const [data, setData] = useState<any>(null);

  useEffect(() => {
    const getData = async () => {
      const response = await fetch("http://localhost:8080/", {
        mode: "cors",
        headers: {
          "Content-Type": "application/json",
        },
      });

      const data = await response.json();
      setData(data);
    };

    getData();
  }, []);

  console.log(data);

  return (
    <>
      {data && (
        <img
          src={`data:image/jpeg;base64, ${data[0].image}`}
          width={300}
          height={500}
        />
      )}
    </>
  );
}
