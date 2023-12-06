import { useEffect, useState } from "react";
import { DataType, ImageType } from "../types";

type GalleryTypes = {
  label: string;
};

export default function Gallery({ label }: GalleryTypes) {
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
          .filter((word) => word.label.includes(label))
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
