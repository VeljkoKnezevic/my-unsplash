import { useEffect, useState } from "react";
import { DataType, ImageType } from "../types";

export default function Gallery() {
  // eslint-disable-next-line @typescript-eslint/no-explicit-any
  const [data, setData] = useState<DataType | null>(null);

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
  }, [data]);

  return (
    <>
      {data &&
        data
          .sort((a, b) => {
            return b.id - a.id;
          })
          .map((image: ImageType) => {
            return (
              <img
                key={image.id}
                src={`data:image/jpeg;base64, ${image.image}`}
                width={300}
                height={500}
              />
            );
          })}
    </>
  );
}
